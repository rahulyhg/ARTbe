package com.kampherbeek.art.domain;

import lombok.Getter;
import lombok.NonNull;

public class BodyPosition {

    @Getter
    private final BasePosition coordinates;
    @Getter
    private final BasePosition speed;

    public BodyPosition(@NonNull BasePosition coordinates, @NonNull BasePosition speed) {
        this.coordinates = coordinates;
        this.speed = speed;
    }
}
