package com.kampherbeek.art.domain;

import lombok.Getter;
import lombok.NonNull;

public enum EphemerisRanges {
    FULL("ephemeris.files.full"),
    EXPANDED("ephemeris.files.expanded"),
    CURRENT("ephemeris.files.current");

    @Getter
    private final String propertyName;

    EphemerisRanges(@NonNull String propertyName) {
        this.propertyName = propertyName;
    }
}
