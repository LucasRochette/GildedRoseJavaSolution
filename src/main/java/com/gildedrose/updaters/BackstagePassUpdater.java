package com.gildedrose.updaters;

import com.gildedrose.Item;
import com.gildedrose.Updater;

public class BackstagePassUpdater implements Updater {
    @Override
    public void update(Item item) {
        if (isAfterTheConcert(item)) {
            item.quality = MINIMUM_QUALITY;
        }
        else if (isUnderHighestQualityValue(item)) {
            int qualityIncrease = getQualityIncreaseForPass(item.sellIn);
            item.quality += qualityIncrease;
        }

        decreaseSellIn(item);
    }

    private int getQualityIncreaseForPass(int remainingDaysBeforeConcert) {
        if (remainingDaysBeforeConcert <= 5) {
            return 3;
        }
        if (remainingDaysBeforeConcert <= 10) {
            return 2;
        }
        return 1;
    }

    private boolean isAfterTheConcert(Item item) {
        return isPastExpirationDate(item);
    }
}
