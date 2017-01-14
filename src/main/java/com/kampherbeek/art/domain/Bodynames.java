package com.kampherbeek.art.domain;

import static swisseph.SweConst.SE_ECL_NUT;

public enum Bodynames {
    EPSILON(SE_ECL_NUT, 100, "bodynames.epsilon"),
    SUN(0, 0, "bodynames.sun"),
    MOON(1, 1, "bodynames.moon"),
    MERCURY(2, 2, "bodynames.mercury"),
    VENUS(3, 3, "bodynames.venus"),
    MARS(4, 4, "bodynames.mars"),
    JUPITER(5, 5, "bodynames.jupiter"),
    SATURN(6, 6, "bodynames.saturn"),
    URANUS(7, 7, "bodynames.uranus"),
    NEPTUNE(8, 8, "bodynames.neptune"),
    PLUTO(9, 9, "bodynames.pluto"),
    NODE_MEAN(10, 10, "bodynames.node_mean"),
    CHEIRON(15, 15, "bodynames.cheiron"),;

    private final int seId;
    private final int internalId;
    private final String rbKey;

    Bodynames(int seId, int internalId, String rbKey) {
        this.seId = seId;
        this.internalId = internalId;
        this.rbKey = rbKey;
    }

    /**
     * Getter for seId, the value as used by the Swiss Ephemeris.
     * If a body is not supported by the SE, this value will be -999.
     *
     * @return Value for seId, the internalId as used by the Swiss Ephemeris, or -999 if SE does not handle the body.
     */
    public int getSeId() {
        return seId;
    }

    public int getInternalId() {
        return internalId;
    }

    /**
     * Getter for rbKey
     *
     * @return key to access Resource Bundle.
     */
    public String getRbKey() {
        return rbKey;
    }
}
