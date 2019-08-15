package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    private void updateSellIn(Item item) {
        item.sellIn -= 1;
    }

    private void updateQuality(Item item, int rate) {
        item.quality += rate;
        if (item.quality > 50) {
            item.quality = 50;
        }
        if (item.quality < 0) {
            item.quality = 0;
        }
    }

    private void updateAgedBrie(Item item) {
        updateSellIn(item);
            if (item.sellIn <=0) {
                updateQuality(item, 1);
            }
            updateQuality(item, 1);
    }

    private void updateBackstagePass(Item item) {
        updateSellIn(item);
        updateQuality(item, 1);
        if (item.sellIn <= 10) {
            updateQuality(item, 1);
        }
        if (item.sellIn <= 5) {
            updateQuality(item, 1);
        }

        if (item.sellIn <= 0) {
            item.quality = 0;
        }
    }

    private void updateOtherItem(Item item) {
        updateSellIn(item);
        if (item.sellIn <= 0) {
            updateQuality(item, -1);
        }
        updateQuality(item, -1);
    }

    private void updateConjured(Item item) {
        updateSellIn(item);
        if (item.sellIn <= 0) {
            updateQuality(item, -2);
        }
        updateQuality(item, -2);
    }

    public void updateQuality() {
        for (Item currentItem : items) {
            if (currentItem.name.startsWith("Sulfuras")) {
                continue;
            } else if (currentItem.name.equals("Aged Brie")) {
                updateAgedBrie(currentItem);
            } else if (currentItem.name.startsWith("Backstage pass")) {
                updateBackstagePass(currentItem);
            } else if (currentItem.name.startsWith("Conjured")) {
                updateConjured(currentItem);
            } else {
                updateOtherItem(currentItem);
            }
        }
    }
}