package com.gildedrose.updaters;

import com.gildedrose.Item;
import com.gildedrose.Updater;

public class ConjuredItemUpdater implements Updater {
    @Override
    public void update(Item item) {
        item.quality -= 2;
        if (item.quality < MINIMUM_QUALITY) {
            item.quality = MINIMUM_QUALITY;
        }

        decreaseSellIn(item);
    }
}
