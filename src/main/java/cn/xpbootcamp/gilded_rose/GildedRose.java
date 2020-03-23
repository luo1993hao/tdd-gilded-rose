package cn.xpbootcamp.gilded_rose;

import java.util.Objects;

public class GildedRose {
    private static final int DEFAULT_QUALITY = 30;
    private int quality;
    private int SellIn;
    private GoodsType goodsType;

    public static GildedRose buildNormalGoods(int sellIn) {
        return new GildedRose(calculateQualityBySellInAndType(sellIn, GoodsType.NORMAL), sellIn, GoodsType.NORMAL);
    }

    public static GildedRose buildAgedBrie(int sellIn) {
        return new GildedRose(calculateQualityBySellInAndType(sellIn, GoodsType.AGED_BRIE), sellIn, GoodsType.AGED_BRIE);
    }

    public static GildedRose buildSulfuras(int sellIn) {
        return new GildedRose(calculateQualityBySellInAndType(sellIn, GoodsType.SULFURAS), sellIn, GoodsType.SULFURAS);

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

        int nowQuality = 0;
        if (goodsType.equals(GoodsType.NORMAL)) {
            nowQuality = calculateNormalQuality(sellIn);
        }
        if (Objects.equals(goodsType, GoodsType.AGED_BRIE)) {
            nowQuality = calculateAgedBrieQuality(sellIn);
        }
        if (Objects.equals(goodsType, GoodsType.SULFURAS)) {
            nowQuality = calculateSulfuras();
        }

        if (nowQuality < 0) {
            return 0;
        }
        return Math.min(nowQuality, 50);
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

    private static int calculateSulfuras() {
        return DEFAULT_QUALITY;
    }

    public enum GoodsType {
        NORMAL, AGED_BRIE, SULFURAS, BACKSTAGE_PASS;
    }
}
