package com.gildedrose;

import java.util.Date;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void process() {
        for (Item item : items) {
            updateQuality(item);
            updateSellIn(item);
            handleExpiredItem(item);
            logItemProcessing(item);
        }
    }

    private void updateQuality(Item item) {
        if (isLegendaryItem(item)) {
            return; // Legendary items never change quality
        }

        if (isQualityIncreasingItem(item)) {
            increaseQuality(item);

            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                handleBackstagePassQuality(item);
            }
        } else {
            decreaseQuality(item);

            if (item.name.equals("Conjured Mama Cakes")) {
                decreaseQuality(item); // Conjured items degrade twice as fast
            }
        }
    }

    private boolean isLegendaryItem(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isQualityIncreasingItem(Item item) {
        return item.name.equals("Aged Brie")
                || item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }

    private void handleBackstagePassQuality(Item item) {
        if (item.sellIn < 11 && item.quality < 50) {
            if (item.sellIn < 6) {
                item.quality += 2;
            } else {
                item.quality += 1;
            }
        }
    }

    private void updateSellIn(Item item) {
        if (!isLegendaryItem(item)) {
            item.sellIn -= 1;
        }
    }

    private void handleExpiredItem(Item item) {
        if (item.sellIn < 0) {
            if (item.name.equals("Aged Brie")) {
                increaseQuality(item);
            } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                item.quality = 0;
            } else if (!isLegendaryItem(item)) {
                decreaseQuality(item);
            }
        }
    }

    private void logItemProcessing(Item item) {
        System.out.println("Processed: " + item.name + " @ " + new Date());
    }
}
