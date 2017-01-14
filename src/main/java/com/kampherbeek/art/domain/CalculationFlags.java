package com.kampherbeek.art.domain;

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

    private final int seFlagId;

    CalculationFlags(int seFlagId) {
        this.seFlagId = seFlagId;
    }

    /**
     * Return the id of this flag, this id corresponds with the value as used in the Swiss Ephemeris.
     *
     * @return id of the flag.
     */
    public int getFlagId() {
        return seFlagId;
    }

}
