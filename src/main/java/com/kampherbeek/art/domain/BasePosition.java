package com.kampherbeek.art.domain;

import lombok.Getter;

public class BasePosition {
    @Getter
    private final double mainValue;
    @Getter
    private final double deviation;
    @Getter
    private final double distance;

    /**
     * Coordinates for a single positions , or the speed of these coordinates.
     *
     * @param mainValue Main position along a great circle, e.g. right ascension.
     * @param deviation Deviation from main circle, e.g. declination.
     * @param distance  Distance in Astronomical Units.
     */
    public BasePosition(double mainValue, double deviation, double distance) {
        this.mainValue = mainValue;
        this.deviation = deviation;
        this.distance = distance;
    }

}
