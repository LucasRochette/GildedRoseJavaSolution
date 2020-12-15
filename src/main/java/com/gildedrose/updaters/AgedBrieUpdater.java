package com.gildedrose.updaters;

import com.gildedrose.Item;
import com.gildedrose.Updater;

public class AgedBrieUpdater implements Updater {
    @Override
    public void update(Item item) {
        if (isUnderHighestQualityValue(item)) {
            increaseQuality(item);
        }
        decreaseSellIn(item);
    }
}
