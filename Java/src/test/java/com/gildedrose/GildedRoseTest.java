package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

class GildedRoseTest {

    @Test
    void brieDecreasesBy1SellInAndIncreasesBy1Or2QualityWhenUpdating() {
        Item[] items = new Item[] {
            new Item("Aged Brie", 13, 60),
            new Item("Aged Brie", 8, 49),
            new Item("Aged Brie", -8, 49),
            new Item("Aged Brie", 3, 10),
            new Item("Aged Brie", -3, -3)
        };
        GildedRose app = new GildedRose(items);
        System.out.println("Before: " + Arrays.toString(items));
        app.updateQuality();
        System.out.println("After: " + Arrays.toString(items));
        assertEquals("Aged Brie", app.items[0].name);
        assertEquals("Aged Brie", app.items[1].name);
        assertEquals("Aged Brie", app.items[2].name);
        assertEquals("Aged Brie", app.items[3].name);
        assertEquals("Aged Brie", app.items[4].name);

        assertEquals(12, app.items[0].sellIn);
        assertEquals(7, app.items[1].sellIn);
        assertEquals(-9, app.items[2].sellIn);
        assertEquals(2, app.items[3].sellIn);
        assertEquals(-4, app.items[4].sellIn);

        assertEquals(60, app.items[0].quality);
        assertEquals(50, app.items[1].quality);
        assertEquals(50, app.items[2].quality);
        assertEquals(11, app.items[3].quality);
        assertEquals(-1, app.items[4].quality);
    }

    @Test
    void sulfurasHandRagnarosStaysTheSameWhenUpdating() {
        Item[] items = new Item[] {
            new Item("Sulfuras, Hand of Ragnaros", 10, 3),
            new Item("Sulfuras, Hand of Ragnaros", -1, 1),
            new Item("Sulfuras, Hand of Ragnaros", 0, 0)
        };
        GildedRose app = new GildedRose(items);
        System.out.println("Before: " + Arrays.toString(items));
        app.updateQuality();
        System.out.println("After: " + Arrays.toString(items));
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[0].name);
        assertEquals(10, app.items[0].sellIn);
        assertEquals(3, app.items[0].quality);
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[1].name);
        assertEquals(-1, app.items[1].sellIn);
        assertEquals(1, app.items[1].quality);
        assertEquals("Sulfuras, Hand of Ragnaros", app.items[2].name);
        assertEquals(0, app.items[2].sellIn);
        assertEquals(0, app.items[2].quality);
    }

    @Test
    void backstageDecreasesBy1SellInAndIncreasesOr0QualityWhenUpdating() {
        Item[] items = new Item[] {
            new Item("Backstage passes to a TAFKAL80ETC concert", -4, -3),
            new Item("Backstage passes to a TAFKAL80ETC concert", 4, 3),
            new Item("Backstage passes to a TAFKAL80ETC concert", 7, 2),
            new Item("Backstage passes to a TAFKAL80ETC concert", 12, 51),
            new Item("Backstage passes to a TAFKAL80ETC concert", 1, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, -100)
        };
        GildedRose app = new GildedRose(items);
        System.out.println("Before: " + Arrays.toString(items));
        app.updateQuality();
        System.out.println("After: " + Arrays.toString(items));
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[0].name);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[1].name);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[2].name);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[3].name);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[4].name);
        assertEquals("Backstage passes to a TAFKAL80ETC concert", app.items[5].name);

        assertEquals(-5, app.items[0].sellIn);
        assertEquals(3, app.items[1].sellIn);
        assertEquals(6, app.items[2].sellIn);
        assertEquals(11, app.items[3].sellIn);
        assertEquals(0, app.items[4].sellIn);
        assertEquals(-1, app.items[5].sellIn);

        assertEquals(0, app.items[0].quality);
        assertEquals(6, app.items[1].quality);
        assertEquals(4, app.items[2].quality);
        assertEquals(51, app.items[3].quality);
        assertEquals(50, app.items[4].quality);
        assertEquals(0, app.items[5].quality);
    }

    @Test
    void randomNameDecreasesBy1SellInAndDecreasesBy1Or2QualityWhenUpdating() {
        Item[] items = new Item[] {
            new Item("random name", 13, 30),
            new Item("random name", 8, 1),
            new Item("random name", -8, 1),
            new Item("random name", 3, -4),
            new Item("random name", -3, 4)
        };
        GildedRose app = new GildedRose(items);
        System.out.println("Before: " + Arrays.toString(items));
        app.updateQuality();
        System.out.println("After: " + Arrays.toString(items));
        assertEquals("random name", app.items[0].name);
        assertEquals("random name", app.items[1].name);
        assertEquals("random name", app.items[2].name);
        assertEquals("random name", app.items[3].name);
        assertEquals("random name", app.items[4].name);

        assertEquals(12, app.items[0].sellIn);
        assertEquals(7, app.items[1].sellIn);
        assertEquals(-9, app.items[2].sellIn);
        assertEquals(2, app.items[3].sellIn);
        assertEquals(-4, app.items[4].sellIn);

        assertEquals(29, app.items[0].quality);
        assertEquals(0, app.items[1].quality);
        assertEquals(0, app.items[2].quality);
        assertEquals(-4, app.items[3].quality);
        assertEquals(2, app.items[4].quality);
    }

}
