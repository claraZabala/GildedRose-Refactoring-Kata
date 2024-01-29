package com.gildedrose;

class GildedRose {
    public static final String BRIE = "Aged Brie";
    public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQualityFirst(item);
            updateSellIn(item);
            updateQualitySecond(item);
        }
    }

    private void updateQualityFirst(Item item) {
        switch (item.name) {
            case BRIE:
                updateQualityMinor50(item);
                break;
            case BACKSTAGE:
                updateBackstageQuality(item);
                break;
            case SULFURAS:
                break;
            default:
                updateDefaultQuality(item);
        }
    }

    private static void updateQualityMinor50(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
    }

    private static void updateBackstageQuality(Item item) {
        updateQualityMinor50(item);
        if (item.quality < 50 && item.sellIn < 11) {
            item.quality += 1;
        }
        if (item.quality < 50 && item.sellIn < 6) {
            item.quality += 1;
        }
    }

    private static void updateSellIn(Item item) {
        if (!item.name.equals(SULFURAS)) {
            item.sellIn -= 1;
        }
    }

    private static void updateQualitySecond(Item item) {
        if (item.sellIn < 0) {
            switch (item.name) {
                case BRIE:
                    updateQualityMinor50(item);
                    break;
                case BACKSTAGE:
                    item.quality = 0;
                    break;
                case SULFURAS:
                    break;
                default:
                    updateDefaultQuality(item);
            }
        }
    }

    private static void updateDefaultQuality(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
    }
}
