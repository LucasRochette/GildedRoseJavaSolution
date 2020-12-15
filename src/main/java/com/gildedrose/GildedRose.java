package com.gildedrose;

class GildedRose {
    public static final int MINIMUM_QUALITY = 0;
    public static final int MAXIMUM_QUALITY = 50;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Aged Brie")
                    && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                // Normal item
                if (item.quality > MINIMUM_QUALITY) {
                    if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                        // Normal item
                        decreaseQuality(item);
                    }
                    // Implicit else: Legendary item
                }
            } else {
                // Aged Brie or Backstage pass
                if (isUnderHighestQualityValue(item)) {
                    increaseQuality(item);

                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        // Only Backstage pass, increase by 2 when is less than 10 days before concert
                        if (item.sellIn < 11) {
                            if (isUnderHighestQualityValue(item)) {
                                increaseQuality(item);
                            }
                        }

                        // Only Backstage pass, increase by 3 when is less than 5 days before concert
                        if (item.sellIn < 6) {
                            if (isUnderHighestQualityValue(item)) {
                                increaseQuality(item);
                            }
                        }
                    }
                }
            }

            // Normal item
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals("Aged Brie")) {
                    if (!item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.quality > MINIMUM_QUALITY) {
                            // Normal item except legendary
                            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                                decreaseQuality(item);
                            }
                            // Implicit else: Legendary item
                        }
                    } else {
                        // Backstage pass only
                        item.quality = MINIMUM_QUALITY;
                    }
                } else {
                    // Aged Brie only
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
        return item.quality < MAXIMUM_QUALITY;
    }
}