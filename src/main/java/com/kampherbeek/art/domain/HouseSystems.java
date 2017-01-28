package com.kampherbeek.art.domain;

import lombok.Getter;
import lombok.NonNull;

/**
 * Enum for HouseSystems. The value for seId corresponds with the indexes as used by the Swiss Ephemeris.
 * If the system is not supported by the SE the value for seId = '#'.
 * internalId is the value used internally in ART.
 */
public enum HouseSystems {

    NONE('!', 0, 0, "housesystems.none"),
    PLACIDUS('P', 1, 12, "housesystems.placidus"),
    KOCH('K', 2, 12, "housesystems.koch"),
    PORPHYRI('O', 3, 12, "housesystems.porphyri"),
    REGIOMONTANUS('R', 4, 12, "housesystems.regiomontanus"),
    CAMPANUS('C', 5, 12, "housesystems.campanus"),
    EQUAL_ASC('A', 6, 12, "housesystems.equal_asc"),           // SE also supports 'E'.
    VEHLOW('V', 7, 12, "housesystems.vehlow"),
    WHOLE_SIGN('W', 8, 12, "housesystems.whole_sign"),
    AXIAL_ROTATION('X', 9, 12, "housesystems.axial_rotation"),
    HORIZONTAL('H', 10, 12, "housesystems.horizontal"),
    TOPOCENTRIC('T', 11, 12, "housesystems.topocentric"),
    ALCABITIUS('B', 12, 12, "housesystems.alcabitius"),
    MORIN('M', 13, 12, "housesystems.morin"),
    KRUSINSKI('K', 14, 12, "housesystems.krusinski"),
    GAUQUELIN('G', 15, 36, "housesystems.gauquelin"),
    APC('Y', 16, 12, "housesystems.apc");

    @Getter
    private final char seId;
    @Getter
    private final int internalId;
    @Getter
    private final int nrOfCusps;
    @Getter
    private final String rbKey;

    HouseSystems(char seId, int internalId, int nrOfCusps, @NonNull String rbKey) {
        this.seId = seId;
        this.internalId = internalId;
        this.nrOfCusps = nrOfCusps;
        this.rbKey = rbKey;
    }

}
