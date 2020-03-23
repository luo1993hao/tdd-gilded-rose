package cn.xpbootcamp.gilded_rose;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;


public class GildedRoseTest {

    @Test
    public void should_quality_between_zero_and_fifty() {
        GildedRose overdueGildedRose = new GildedRose(-1);
        MatcherAssert.assertThat(overdueGildedRose.getNowQuality(), Matchers.greaterThan(0));

        GildedRose normalGildedRose = new GildedRose(30);
        MatcherAssert.assertThat(normalGildedRose.getNowQuality(), Matchers.lessThan(50));
    }
}
