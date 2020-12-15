package com.gildedrose.updaters;

import com.gildedrose.Item;
import com.gildedrose.Updater;

public class CommonUpdater implements Updater {
    @Override
    public void update(Item item) {
        if (isAboveLowestQualityValue(item)) {
            decreaseQuality(item);

            if (isPastExpirationDate(item)) {
                decreaseQuality(item);
            }
        }

        decreaseSellIn(item);
    }
}
