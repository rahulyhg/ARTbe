package com.kampherbeek.art.domain;

import com.kampherbeek.art.exceptions.UnknownItemException;
import lombok.Getter;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    CHEIRON(15, 15, "bodynames.cheiron");

    private static final Logger LOG = LoggerFactory.getLogger(Bodynames.class);

    @Getter private final int seId;
    @Getter private final int internalId;
    @Getter private final String rbKey;

    Bodynames(int seId, int internalId, @NonNull String rbKey) {
        this.seId = seId;
        this.internalId = internalId;
        this.rbKey = rbKey;
    }

    public static Bodynames findBodyname4InternalId(int internalId) {
        for (Bodynames bodyname : Bodynames.values()) {
            if (bodyname.getInternalId() == internalId) {
                return bodyname;
            }
        }
        LOG.error("Searching for non-existing body: $d", internalId);
        throw new UnknownItemException("Body", Integer.toString(internalId));
    }
}
