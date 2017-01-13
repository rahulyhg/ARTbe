package com.kampherbeek.art.domain;

import static swisseph.SweConst.*;

public class HousePositions {

    private final HouseSystems system;
    private final double[] cusps;
    private final double[] additionalPoints;
    // additionalPoints has 1- positions, but it only uses the following values:
    // [0] = [SE_ASC] = Longitude Ascendant.
    // [1] = [SE_MC} = Longitude MC.
    // [2] = [SE_ARMC] = Right ascension MC.
    // [3] = [SE_VERTEX] = Longitude of Vertex.
    // [4] = [SE_EQUASC] = Longitude East Point (Equatorial ascendant).


    public HousePositions(HouseSystems system, double[] cusps, double[] additionalPoints) {
        this.system = system;
        this.cusps = cusps;
        this.additionalPoints = additionalPoints;
    }

    public double getMC() {
        return additionalPoints[SE_MC];
    }

    public double getArmc() {
        return additionalPoints[SE_ARMC];
    }
    public double getAscendant() {
        return additionalPoints[SE_ASC];
    }

    public double getVertex() {
        return additionalPoints[SE_VERTEX];
    }

    public double getEastPoint() {
        return additionalPoints[SE_EQUASC];
    }

    public HouseSystems getSystem() {
        return system;
    }

    public double[] getCusps() {
        return cusps;
    }
}
