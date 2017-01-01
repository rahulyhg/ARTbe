package com.kampherbeek.art.domain;

// TODO omzetten op dezelfde manier als IntegerLimits.
public enum FloatingLimits {
    MAX_JULIAN_DAY_NR(7857139.5),       // 7 Jan 16800 CE Gregorian calendar
    MIN_JULIAN_DAY_NR(-3026604.5),      // 11 Aug 13000 BCE (-12999) Julian Calendar
    MAX_LONGITUDE(180.0),
    MIN_LONGITUDE(-180.0),
    MAX_LATITUDE(89.999999),
    MIN_LATITUDE(-89.999999);

    final double value;

    FloatingLimits(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
