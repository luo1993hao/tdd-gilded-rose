package cn.xpbootcamp.gilded_rose;

import java.util.Arrays;
import java.util.Objects;

public class GildedRose {
    private static final int DEFAULT_QUALITY = 30;
    private int quality;
    private int SellIn;
    private GoodsType goodsType;

    public static GildedRose buildGoods(int sellIn, GoodsType goodsType) {
        return new GildedRose(calculateQualityBySellInAndType(sellIn, goodsType), sellIn, goodsType);

    }

    public static GildedRose buildNormalGoods(int sellIn) {
        return new GildedRose(calculateQualityBySellInAndType(sellIn, GoodsType.NORMAL), sellIn, GoodsType.NORMAL);
    }

    public static GildedRose buildAgedBrie(int sellIn) {
        return new GildedRose(calculateQualityBySellInAndType(sellIn, GoodsType.AGED_BRIE), sellIn, GoodsType.AGED_BRIE);
    }

    public static GildedRose buildSulfuras(int sellIn) {
        return new GildedRose(calculateQualityBySellInAndType(sellIn, GoodsType.SULFURAS), sellIn, GoodsType.SULFURAS);
    }

    public static GildedRose buildBackstagePass(int sellIn) {
        return new GildedRose(calculateQualityBySellInAndType(sellIn, GoodsType.BACKSTAGE_PASS), sellIn, GoodsType.BACKSTAGE_PASS);
    }

    private GildedRose(int quality, int sellIn, GoodsType goodsType) {
        this.quality = quality;
        this.SellIn = sellIn;
        this.goodsType = goodsType;
    }

    public int getQuality() {
        return quality;
    }

    private static int calculateQualityBySellInAndType(int sellIn, GoodsType goodsType) {
        checkGoodsType(goodsType);

        int nowQuality = 0;
        if (goodsType.equals(GoodsType.NORMAL)) {
            nowQuality = calculateNormalQuality(sellIn);
        }
        if (Objects.equals(goodsType, GoodsType.AGED_BRIE)) {
            nowQuality = calculateAgedBrieQuality(sellIn);
        }
        if (Objects.equals(goodsType, GoodsType.SULFURAS)) {
            nowQuality = calculateSulfurasQuality();
        }
        if (Objects.equals(goodsType, GoodsType.BACKSTAGE_PASS)) {
            nowQuality = calculateBackstagePassQuality(sellIn);
        }

        if (nowQuality < 0) {
            return 0;
        }
        return Math.min(nowQuality, 50);
    }

    private static void checkGoodsType(GoodsType goodsType) {
        if (Arrays.stream(GoodsType.values()).noneMatch(x -> x.equals(goodsType))) {
            throw new RuntimeException("illegal goodType");
        }
    }

    private static int calculateNormalQuality(int sellIn) {
        if (sellIn >= 0) {
            return DEFAULT_QUALITY + sellIn;
        } else {
            return DEFAULT_QUALITY + 2 * sellIn;
        }
    }

    private static int calculateAgedBrieQuality(int sellIn) {
        return DEFAULT_QUALITY - sellIn;
    }

    private static int calculateSulfurasQuality() {
        return DEFAULT_QUALITY;
    }

    private static int calculateBackstagePassQuality(int sellIn) {
        int doubleIncreaseTime = 10;
        int trebleIncreaseTime = 5;

        if (sellIn < doubleIncreaseTime && sellIn >= trebleIncreaseTime) {
            return DEFAULT_QUALITY + 2 * (doubleIncreaseTime - sellIn);
        }
        if (sellIn < trebleIncreaseTime && sellIn >= 0) {
            int doubleIncreaseTotal = 2 * 5;
            return DEFAULT_QUALITY + doubleIncreaseTotal + 3 * (trebleIncreaseTime - sellIn);
        }
        if (sellIn < 0) {
            return 0;
        }
        throw new RuntimeException("illegal sellIn");
    }
}

enum GoodsType {
    NORMAL, AGED_BRIE, SULFURAS, BACKSTAGE_PASS;
}

