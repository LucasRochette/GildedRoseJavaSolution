package com.gildedrose;

import com.gildedrose.updaters.AgedBrieUpdater;
import com.gildedrose.updaters.BackstagePassUpdater;
import com.gildedrose.updaters.CommonUpdater;
import com.gildedrose.updaters.LegendaryUpdater;

import java.util.List;
import java.util.Map;

public class UpdaterFactory {
    public static final String BACKSTAGE_PASSES = "backstage-passes";
    public static final String LEGENDARY = "legendary";
    public static final String IMPROVES_WITH_AGE = "improves-with-age";

    private static final Map<String, List<String>> itemTypes = Map.of(BACKSTAGE_PASSES, List.of("Backstage passes to a TAFKAL80ETC concert"), LEGENDARY, List.of("Sulfuras, Hand of Ragnaros"), IMPROVES_WITH_AGE, List.of("Aged Brie"));

    public static Updater updaterFor(Item currentItem) {
        if (improvesWithAge(currentItem)) {
            return new AgedBrieUpdater();
        }

        if(isLegendary(currentItem)) {
            return new LegendaryUpdater();
        }

        if(isBackstagePass(currentItem)) {
            return new BackstagePassUpdater();
        }

        return new CommonUpdater();
    }

    private static boolean improvesWithAge(Item item) {
        return itemTypes.get(IMPROVES_WITH_AGE).contains(item.name);
    }

    private static boolean isBackstagePass(Item item) {
        return itemTypes.get(BACKSTAGE_PASSES).contains(item.name);
    }

    private static boolean isLegendary(Item item) {
        return itemTypes.get(LEGENDARY).contains(item.name);
    }
}
