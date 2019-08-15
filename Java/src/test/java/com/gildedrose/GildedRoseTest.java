package com.gildedrose;

import static org.junit.Assert.*;

import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void SulfurasQualityShouldRemain80() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals( 0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    public void AgedBrieShouldIncreaseQualityBy1UntilSellByDate() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 1) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals( 1, app.items[0].sellIn);
        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void AgedBrieShouldIncreaseQualityBy2AfterSellByDate() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 5) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals( -1, app.items[0].sellIn);
        assertEquals(7, app.items[0].quality);
    }

    @Test
    public void AgedBrieShouldNotIncreaseQualityOver50() {
        Item[] items = new Item[] { new Item("Aged Brie", 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals( 9, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void BackstagePassShouldIncreaseQualityBy3WhenSellByDateLessThan5() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 5, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals( 4, app.items[0].sellIn);
        assertEquals(13, app.items[0].quality);
    }

    @Test
    public void BackstagePassShouldIncreaseQualityBy2WhenSellByDateLessThan10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals( 9, app.items[0].sellIn);
        assertEquals(12, app.items[0].quality);
    }

    @Test
    public void BackstagePassShouldIncreaseQualityBy1WhenSellByDateMoreThan10() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 12, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals( 11, app.items[0].sellIn);
        assertEquals(11, app.items[0].quality);
    }

    @Test
    public void BackstagePassShouldHaveQuality0WhenSellByDateLessThan0() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 0, 10) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals( -1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void BackstagePassShouldNotIncreaseQualityOver50() {
        Item[] items = new Item[] { new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
        assertEquals( 9, app.items[0].sellIn);
    }

    @Test
    public void OtherItemShouldDecreaseQualityBy1TillSellByDate() {
        Item[] items = new Item[] { new Item("Other", 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals( 9, app.items[0].sellIn);
        assertEquals(49, app.items[0].quality);
    }

    @Test
    public void OtherItemShouldDecreaseQualityBy2AfterSellByDate() {
        Item[] items = new Item[] { new Item("Other", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals( -1, app.items[0].sellIn);
        assertEquals(48, app.items[0].quality);
    }

    @Test
    public void ConjuredShouldDecreaseQualityBy2BeforeSellByDate() {
        Item[] items = new Item[] { new Item("Conjured", 10, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals( 9, app.items[0].sellIn);
        assertEquals(48, app.items[0].quality);
    }

    @Test
    public void ConjuredShouldDecreaseQualityBy4AfterSellByDate() {
        Item[] items = new Item[] { new Item("Conjured", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals( -1, app.items[0].sellIn);
        assertEquals(46, app.items[0].quality);
    }

    @Test
    public void QualityShouldNotBeLessThan0() {
        Item[] items = new Item[] { new Item("Other", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals( -1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);

    }
}
