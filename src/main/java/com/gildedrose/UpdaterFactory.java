package com.gildedrose;

import com.gildedrose.updaters.*;

import java.util.List;
import java.util.Map;

public class UpdaterFactory {
    public static final String BACKSTAGE_PASSES = "backstage-passes";
    public static final String CONJURED = "conjured";
    public static final String IMPROVES_WITH_AGE = "improves-with-age";
    public static final String LEGENDARY = "legendary";

    private static final Map<String, List<String>> itemTypes = Map.of(BACKSTAGE_PASSES, List.of("Backstage passes to a TAFKAL80ETC concert"), LEGENDARY, List.of("Sulfuras, Hand of Ragnaros"), IMPROVES_WITH_AGE, List.of("Aged Brie"), CONJURED, List.of("Conjured Mana Cake"));

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

        if (isConjured(currentItem)) {
            return new ConjuredItemUpdater();
        }

        return new CommonUpdater();
    }

    private static boolean improvesWithAge(Item item) {
        return itemTypes.get(IMPROVES_WITH_AGE).contains(item.name);
    }

    private static boolean isBackstagePass(Item item) {
        return itemTypes.get(BACKSTAGE_PASSES).contains(item.name);
    }

    private static boolean isConjured(Item item) {
        return itemTypes.get(CONJURED).contains(item.name);
    }

    private static boolean isLegendary(Item item) {
        return itemTypes.get(LEGENDARY).contains(item.name);
    }
}
