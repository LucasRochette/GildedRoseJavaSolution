package com.gildedrose;

import static com.gildedrose.UpdaterFactory.updaterFor;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updaterFor(item).update(item);
        }
    }
}