package com.kampherbeek.art.domain;

public class BodyPosition {

    private final Bodynames bodyname;
    private final BasePosition coordinates;
    private final BasePosition speed;


    public BodyPosition(Bodynames bodyname, BasePosition coordinates, BasePosition speed) {
        this.bodyname = bodyname;
        this.coordinates = coordinates;
        this.speed = speed;
    }

    public Bodynames getBodyname() {
        return bodyname;
    }

    public BasePosition getCoordinates() {
        return coordinates;
    }

    public BasePosition getSpeed() {
        return speed;
    }
}
