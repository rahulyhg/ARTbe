package com.kampherbeek.art.domain;

import lombok.Getter;

public enum IntegerLimits {

    YEAR(-13000, 16800),
    MONTH(1, 12),
    DAY(1, 31),
    HOUR(0, 23),
    MINUTE(0, 59),
    SECOND(0, 59);

    @Getter
    private final int minValue;
    @Getter
    private final int maxValue;

    IntegerLimits(final int minValue, final int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

}
