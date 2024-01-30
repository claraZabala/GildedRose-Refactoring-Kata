package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED = "Conjured Mana Cake";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQualityAndSellIn() {
        for (Item item : items) {
            switch (item.name) {
                case AGED_BRIE:
                    item.quality++;
                    break;
                case BACKSTAGE_PASSES:
                    increaseBackstageQuality(item);
                    break;
                case SULFURAS:
                    break;
                case CONJURED:
                    item.quality -= 2;
                    break;
                default:
                    item.quality--;
            }

            updateSellInAndQualityPassedSellIn(item);

            validateQuality(item);
        }
    }

    private static void updateSellInAndQualityPassedSellIn(Item item) {
        lowerSellInDays(item);
        if (item.sellIn < 0) {
            updateQualityPassedSellDate(item);
        }
    }

    private static void validateQuality(Item item) {
        if (item.quality > 50) {
            item.quality = 50;
        }
        if (item.quality < 0) {
            item.quality = 0;
        }
    }

    private static void increaseBackstageQuality(Item item) {
        if (item.sellIn > 5 && item.sellIn <= 10) {
            item.quality += 2;
        }

        if (item.sellIn <= 5) {
            item.quality += 3;
        }
    }

    private static void lowerSellInDays(Item item) {
        if (!item.name.equals(SULFURAS)) {
            item.sellIn--;
        }
    }

    private static void updateQualityPassedSellDate(Item item) {
        switch (item.name) {
            case AGED_BRIE:
                item.quality++;
                break;
            case BACKSTAGE_PASSES:
                item.quality = 0;
                break;
            case SULFURAS:
                break;
            case CONJURED:
                item.quality -= 2;
                break;
            default:
                item.quality--;
        }
    }
}
