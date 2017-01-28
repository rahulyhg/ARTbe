package com.kampherbeek.art.domain;

import lombok.Getter;

public class Location {

    @Getter
    private double longitude;
    @Getter
    private double latitude;

    public Location() {
        // empty constructor for Json
    }

    public Location(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

}
