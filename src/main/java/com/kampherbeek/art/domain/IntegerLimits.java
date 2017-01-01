package com.kampherbeek.art.domain;

public enum IntegerLimits {

    YEAR(-13000, 16800),
    MONTH(1, 12),
    DAY(1, 31),
    HOUR(0, 23),
    MINUTE(0, 59),
    SECOND(0, 59);

    private int minValue;
    private int maxValue;

    IntegerLimits(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public int getMinValue() {
        return minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }
}
