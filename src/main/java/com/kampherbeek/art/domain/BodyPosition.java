package com.kampherbeek.art.domain;

public class BodyPosition {

    private final BasePosition coordinates;
    private final BasePosition speed;

    public BodyPosition(BasePosition coordinates, BasePosition speed) {
        this.coordinates = coordinates;
        this.speed = speed;
    }

    public BasePosition getCoordinates() {
        return coordinates;
    }

    public BasePosition getSpeed() {
        return speed;
    }
}
