package com.kampherbeek.art.domain;

import lombok.Getter;
import lombok.NonNull;

/**
 * Items that define the flags for the Swiss Ephemeris.
 */
public enum SeFlags {
    SE(2L, "se"),
    HELIO(8L, "heliocentric"),
    SPEED(256L, "speed"),
    EQUATORIAL(2048L, "equatorial"),
    PARALLAX(32768L, "parallax"),
    SIDEREAL(65536L, "sidereal");

    @Getter
    private long seId;

    @Getter
    private String artId;

    SeFlags(final long seId, @NonNull final String artId) {
        this.seId = seId;
        this.artId = artId;
    }
}


