package cn.xpbootcamp.gilded_rose;

public class GildedRose {
    private static final int DEFAULT_QUALITY = 30;
    private int quality;
    private int SellIn;

    public static GildedRose buildGildedRose(int sellIn) {
        GildedRose gildedRose = new GildedRose();
        gildedRose.setSellIn(sellIn);
        gildedRose.setQuality(getQualityBySellIn(sellIn));
        return gildedRose;
    }


    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getSellIn() {
        return SellIn;
    }

    public void setSellIn(int sellIn) {
        SellIn = sellIn;
    }

    private static int getQualityBySellIn(int sellIn) {

        int nowQuality;
        if (sellIn >= 0) {
            nowQuality = DEFAULT_QUALITY + sellIn;
        } else {
            nowQuality = DEFAULT_QUALITY + 2 * sellIn;
        }

        if (nowQuality < 0) {
            return 0;
        }
        return Math.min(nowQuality, 50);
    }
}
