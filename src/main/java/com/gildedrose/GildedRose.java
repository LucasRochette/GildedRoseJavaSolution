package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.quality > 0) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        decreaseQuality(item);
                    }
                }
            } else {
                if (isUnderHighestQualityValue(item)) {
                    increaseQuality(item);

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {
                            if (isUnderHighestQualityValue(item)) {
                                increaseQuality(item);
                            }
                        }

                        if (item.sellIn < 6) {
                            if (isUnderHighestQualityValue(item)) {
                                increaseQuality(item);
                            }
                        }
                    }
                }
            }

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > 0) {
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                decreaseQuality(item);
                            }
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (isUnderHighestQualityValue(item)) {
                        increaseQuality(item);
                    }
                }
            }
        }
    }

    private void decreaseQuality(Item item) {
        item.quality = item.quality - 1;
    }

    private void increaseQuality(Item item) {
        item.quality = item.quality + 1;
    }

    private boolean isUnderHighestQualityValue(Item item) {
        return item.quality < 50;
    }
}