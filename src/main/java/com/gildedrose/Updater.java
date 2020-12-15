package com.gildedrose;

public interface Updater {
    int MINIMUM_QUALITY = 0;
    int MAXIMUM_QUALITY = 50;

    void update(Item item);

    default void decreaseSellIn(Item item) {
        item.sellIn--;
    }

    default void decreaseQuality(Item item) {
        item.quality--;
    }

    default void increaseQuality(Item item) {
        item.quality++;
    }

    default boolean isAboveLowestQualityValue(Item item) {
        return item.quality > MINIMUM_QUALITY;
    }

    default boolean isUnderHighestQualityValue(Item item) {
        return item.quality < MAXIMUM_QUALITY;
    }

    default boolean isPastExpirationDate(Item item) {
        return item.sellIn <= 0;
    }
}
