package com.kampherbeek.art.domain;

import lombok.Getter;
import swisseph.SweConst;

/**
 * Flags to define the way calcResults are being calculated by he Swiss Ephemeris.
 */
public enum CalculationFlags {
    SWIEPH(SweConst.SEFLG_SWIEPH),
    HELCTR(SweConst.SEFLG_HELCTR),
    TRUEPOS(SweConst.SEFLG_TRUEPOS),
    SPEED(SweConst.SEFLG_SPEED),
    EQUATORIAL(SweConst.SEFLG_EQUATORIAL),
    XYZ(SweConst.SEFLG_XYZ),
    TOPOCTR(SweConst.SEFLG_TOPOCTR),
    SIDEREAL(SweConst.SEFLG_SIDEREAL);

    @Getter
    private final int flagId;

    CalculationFlags(int flagId) {
        this.flagId = flagId;
    }

}
