package com.gildedrose.updaters;

import com.gildedrose.Item;
import com.gildedrose.Updater;

public class LegendaryUpdater implements Updater {
    @Override
    public void update(Item item) {
        // Nothing to do here: the item keeps its quality and should not be sold
    }
}
