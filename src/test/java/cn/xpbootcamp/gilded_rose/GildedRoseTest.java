package cn.xpbootcamp.gilded_rose;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;


public class GildedRoseTest {

    @Test
    void should_quality_between_zero_and_fifty() {
        GildedRose overdueGildedRose = GildedRose.buildNormalGoods(-100);
        MatcherAssert.assertThat(overdueGildedRose.getQuality(), Matchers.greaterThanOrEqualTo(0));

        GildedRose normalGildedRose = GildedRose.buildNormalGoods(50);
        MatcherAssert.assertThat(normalGildedRose.getQuality(), Matchers.lessThanOrEqualTo(50));
    }

    @Test
    void should_double_decrease_quality_when_sellIn_less_than_zero() {
        GildedRose normalGildedRose1 = GildedRose.buildNormalGoods(1);
        GildedRose normalGildedRose0 = GildedRose.buildNormalGoods(0);
        int normalDecrease = normalGildedRose1.getQuality() - normalGildedRose0.getQuality();
        GildedRose overdueGildedRose1 = GildedRose.buildNormalGoods(-1);
        int overDueDecrease = normalGildedRose0.getQuality() - overdueGildedRose1.getQuality();
        MatcherAssert.assertThat(overDueDecrease / normalDecrease, Matchers.equalTo(2));

    }

    @Test
    void should_increase_quality_when_goods_is_aged_brie() {
        GildedRose agedBrie0 = GildedRose.buildAgedBrie(1);
        GildedRose agedBrie1 = GildedRose.buildAgedBrie(-1);
        MatcherAssert.assertThat(agedBrie1.getQuality() - agedBrie0.getQuality(), Matchers.greaterThan(0));
    }
}
