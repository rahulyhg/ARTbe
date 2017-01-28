package com.kampherbeek.art.domain;

import lombok.Getter;
import lombok.NonNull;

import static swisseph.SweConst.*;

public class HousePositions {


    @Getter
    private final HouseSystems system;
    @Getter
    private final double[] cusps;
    @Getter
    private final double mc;
    @Getter
    private final double armc;
    @Getter
    private final double ascendant;
    @Getter
    private final double vertex;
    @Getter
    private final double eastPoint;

    // additionalPoints has 10 positions, but it only uses the following values:
    // [0] = [SE_ASC] = Longitude Ascendant.
    // [1] = [SE_MC} = Longitude MC.
    // [2] = [SE_ARMC] = Right ascension MC.
    // [3] = [SE_VERTEX] = Longitude of Vertex.
    // [4] = [SE_EQUASC] = Longitude East Point (Equatorial ascendant).

    public HousePositions(@NonNull HouseSystems system, @NonNull double[] cusps, @NonNull double[] additionalPoints) {
        this.system = system;
        this.cusps = cusps;
        mc = additionalPoints[SE_MC];
        armc = additionalPoints[SE_ARMC];
        ascendant = additionalPoints[SE_ASC];
        vertex = additionalPoints[SE_VERTEX];
        eastPoint = additionalPoints[SE_EQUASC];
    }

}
