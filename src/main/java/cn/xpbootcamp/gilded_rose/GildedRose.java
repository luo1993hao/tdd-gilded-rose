package cn.xpbootcamp.gilded_rose;

public class GildedRose {
    private int quality;
    private int SellIn;

    public GildedRose(int sellIn) {
        SellIn = sellIn;
    }

    public int getNowQuality() {
        return (int) (Math.random() * 50);
    }
}
