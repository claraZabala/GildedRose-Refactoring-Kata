package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (item.name.equals(AGED_BRIE) || item.name.equals(BACKSTAGE_PASSES)) {
                increaseQuality(item);
            } else {
                lowerQuality(item);
            }

            lowerSellInDays(item);

            updateQualityPassedSellDate(item);
        }
    }

    private static void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
        if (item.name.equals(BACKSTAGE_PASSES)) {
            if (item.sellIn < 11 && item.quality < 50) {
                item.quality++;
            }

            if (item.sellIn < 6 && item.quality < 50) {
                item.quality++;
            }
        }
    }

    private static void lowerQuality(Item item) {
        if (item.quality > 0 && !item.name.equals(SULFURAS)) {
            item.quality--;
        }
    }

    private static void lowerSellInDays(Item item) {
        if (!item.name.equals(SULFURAS)) {
            item.sellIn--;
        }
    }

    private static void updateQualityPassedSellDate(Item item) {
        if (item.sellIn < 0) {
            if (item.name.equals(AGED_BRIE)) {
                if (item.quality < 50) {
                    item.quality++;
                }
            } else {
                if (!item.name.equals(BACKSTAGE_PASSES)) {
                    if (item.quality > 0 && !item.name.equals(SULFURAS)) {
                        item.quality--;
                    }
                } else {
                    item.quality = 0;
                }
            }
        }
    }
}
