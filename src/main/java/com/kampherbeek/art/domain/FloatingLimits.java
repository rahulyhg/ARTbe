package com.kampherbeek.art.domain;

public enum FloatingLimits {
    JULIAN_DAY_NR(-3026604.5, 7857139.5),       // - 11 Aug 13000 BCE (-12999) Julian  - 7 Jan 16800 CE Gregorian
    LONGITUDE(-180.0, 180.0),
    LATITUDE(-89.999999, 89.999999);

    final double minValue;
    final double maxValue;

    FloatingLimits(double minValue, double maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public double getMinValue() {
        return minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }



}
