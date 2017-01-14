package com.kampherbeek.art.domain;

public class BasePosition {
    private final double mainValue;
    private final double deviation;
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

    /**
     * @return Main position along a great circle, e.g. right ascension.
     */
    public double getMainValue() {
        return mainValue;
    }

    /**
     * @return Deviation from main circle, e.g. declination.
     */
    public double getDeviation() {
        return deviation;
    }

    /**
     * @return Distance in Astronomical Units.
     */
    public double getDistance() {
        return distance;
    }
}
