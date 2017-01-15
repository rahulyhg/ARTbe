package com.kampherbeek.art.domain;

public enum TimeConstants {

    SECONDS_PER_HOUR(3600),
    SECONDS_PER_MINUTE(60),
    MINUTES_PER_HOUR(60);

    private final int value;

    TimeConstants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
