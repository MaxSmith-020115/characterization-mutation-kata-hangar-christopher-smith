package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void intro_implementation_test() {
        Item[] items = new Item[]{new Item("Paisley Pajama Pants", 5, 10)};

        GildedRose app = new GildedRose(items);
        int beforeSellIn = app.items[0].sellIn;
        int beforeQuality = app.items[0].quality;

        app.process();

        // verify normal items, sellIn is decremented by 1
        assertEquals(beforeSellIn - 1, app.items[0].sellIn);

        // verify normal items, quality is decremented by 1
        assertEquals(beforeQuality - 1, app.items[0].quality);
    }

    @Test
    void normalItem_sellIn_decrease_by_one_and_quality_decreases_by_one() {
        Item[] items = new Item[]{new Item("Paisley Pajama Pants", 5, 10)};

        GildedRose app = new GildedRose(items);
        app.process();

        String actual = app.items[0].sellIn + ", " + app.items[0].quality;
        assertEquals("4, 9", actual);
    }

    @Test
    void agedBrie_sellIn_decrease_by_one_and_quality_increases_by_one_positive_sellIn() {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 10)};

        GildedRose app = new GildedRose(items);
        app.process();

        String actual = app.items[0].sellIn + ", " + app.items[0].quality;
        assertEquals("0, 11", actual);
    }

    @Test
    void agedBrie_sellIn_decrease_by_one_and_quality_increases_by_two_negative_sellIn() {
        Item[] items = new Item[]{new Item("Aged Brie", -1, 10)};

        GildedRose app = new GildedRose(items);
        app.process();

        String actual = app.items[0].sellIn + ", " + app.items[0].quality;
        assertEquals("-2, 12", actual);
    }

    @Test
    void backstagePasses_sellIn_decrease_by_one_and_quality_increases_by_three() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 10)};

        GildedRose app = new GildedRose(items);
        app.process();

        String actual = app.items[0].sellIn + ", " + app.items[0].quality;
        assertEquals("0, 13", actual);
    }

    // SECRET TEST ONE TESTS
    @Test
    void agedBrieSellinDegradesByOneQualityIncreasesByTwo() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 0) };

        GildedRose app = new GildedRose(items);
        app.process();

        String actual = app.items[0].sellIn + ", " + app.items[0].quality;
        assertEquals("-1, 2", actual);
    }

    @Test
    void backStagePassesWhenSellInIsLessThanZeroQualityIsZero() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -5, 40) };

        GildedRose app = new GildedRose(items);
        app.process();

        String actual = app.items[0].sellIn + ", " + app.items[0].quality;
        assertEquals("-6, 0", actual);
    }

    @Test
    void normalItem_sellIn_decreases_by_one_and_quality_decreases_by_two() {
        Item[] items = new Item[] { new Item("Foo Butter", -5, 40) };

        GildedRose app = new GildedRose(items);
        app.process();

        String actual = app.items[0].sellIn + ", " + app.items[0].quality;
        assertEquals("-6, 38", actual);
    }

    @Test
    void regularItemWithSellInLessThanZeroAndQualityEqualsOneThenSellinDegradeByOneAndQualityDegradeByTwo() {
        Item[] items = new Item[] { new Item("Ragnaros", -1, 5) };

        GildedRose app = new GildedRose(items);
        app.process();

        String actual = app.items[0].sellIn + ", " + app.items[0].quality;
        assertEquals("-2, 3", actual);
    }

    @Test
    void regularItemWhenSellinDegradesByOneQuallityRemaoinsTheSame() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };

        GildedRose app = new GildedRose(items);
        app.process();

        String actual = app.items[0].sellIn + ", " + app.items[0].quality;
        assertEquals("-1, 0", actual);
    }

    @Test
    void agedBrieSellingNegativeTenQualityZeroSellingDegradedByOneQualityIncreasedByTwo() {
        Item[] items = new Item[] { new Item("Aged Brie", -10, 0) };

        GildedRose app = new GildedRose(items);
        app.process();

        String actual = app.items[0].sellIn + ", " + app.items[0].quality;
        assertEquals("-11, 2", actual);
    }

    // SECRET TEST TWO TESTS
    @Test
    void agedBrieSellinDegradedByOneAndQualityIncreaseByOne() {
        Item[] items = new Item[] { new Item("Aged Brie", 5,5 ) };

        GildedRose app = new GildedRose(items);
        app.process();

        String actual = app.items[0].sellIn + ", " + app.items[0].quality;
        assertEquals("4, 6", actual);
    }

    @Test
    void agedBrieSellinDegradeByOneAndQualityRemainSame() {
        Item[] items = new Item[] { new Item("Aged Brie", 5,51 ) };

        GildedRose app = new GildedRose(items);
        app.process();

        String actual = app.items[0].sellIn + ", " + app.items[0].quality;
        assertEquals("4, 51", actual);
    }

    @Test
    void agedBrieSellinDegradeByOneAndQualityIncreaseByOne() {
        Item[] items = new Item[] { new Item("Aged Brie", 8,40) };

        GildedRose app = new GildedRose(items);
        app.process();

        String actual = app.items[0].sellIn + ", " + app.items[0].quality;
        assertEquals("7, 41", actual);
    }

    @Test
    void backstagePassesSellingDegradeOneQualityStayTheSame() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 0) };

        GildedRose app = new GildedRose(items);
        app.process();

        String actual = app.items[0].sellIn + ", " + app.items[0].quality;
        assertEquals("-1, 0", actual);
    }

    @Test
    void backstageWhenSellinLessThanElevenQualityLessThanFifty() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40) };

        GildedRose app = new GildedRose(items);
        app.process();

        String actual = app.items[0].sellIn + ", " + app.items[0].quality;
        assertEquals("9, 42", actual);
    }

    @Test
    void backstageWhenSellinIsFiveQualityIsFortySellinDecreaseByOneQualityIncreaseByThree() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 40) };

        GildedRose app = new GildedRose(items);
        app.process();

        String actual = app.items[0].sellIn + ", " + app.items[0].quality;
        assertEquals("4, 43", actual);
    }

    // SECRET TEST THREE TESTS

    @Test
    void backstageSellingTenQualitySixtySellingGradesByOneQualityStaysTheSame() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 60) };

        GildedRose app = new GildedRose(items);
        app.process();

        String actual = app.items[0].sellIn + ", " + app.items[0].quality;
        assertEquals("9, 60", actual);
    }

    @Test
    void backstageSellinNegativeTenQualitySixtySellinDegradesByOneQualityIsZero() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", -10, 20) };

        GildedRose app = new GildedRose(items);
        app.process();

        String actual = app.items[0].sellIn + ", " + app.items[0].quality;
        assertEquals("-11, 0", actual);
    }

    @Test
    void sulfurasSellinAndQualityAlwaysStaysTheSame() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -2, 20) };

        GildedRose app = new GildedRose(items);
        app.process();

        String actual = app.items[0].sellIn + ", " + app.items[0].quality;
        assertEquals("-2, 20", actual);
    }

    @Test
    void regularItemQualityGreaterThanOneThenSellinAndQualityDecreasesByOne() {
        Item[] items = new Item[] { new Item("Ragnaros", 1, 3) };

        GildedRose app = new GildedRose(items);
        app.process();

        String actual = app.items[0].sellIn + ", " + app.items[0].quality;
        assertEquals("0, 2", actual);
    }

    @Test
    void regularItemWithSellinLessThanZeroAndQualityZeroThenSellinDegradeByOneAndQualityRemainsSame() {
        Item[] items = new Item[] { new Item("Ragnaros", -1, 0) };

        GildedRose app = new GildedRose(items);
        app.process();

        String actual = app.items[0].sellIn + ", " + app.items[0].quality;
        assertEquals("-2, 0", actual);
    }

    @Test
    void agedBrieSellingGreaterThanZeroQualityGreaterThan49ThenSellingDegradebyOneQualityRemainSame() {
        Item[] items = new Item[] { new Item("Aged Brie", 1, 50) };

        GildedRose app = new GildedRose(items);
        app.process();

        String actual = app.items[0].sellIn + ", " + app.items[0].quality;
        assertEquals("0, 50", actual);
    }
}
