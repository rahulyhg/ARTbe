package com.kampherbeek.art.domain;

import lombok.Getter;
import lombok.NonNull;

/**
 * Result format for cycles, frequency analysis and ephemerids.
 */
public enum PeriodResultFormat {

    SCREEN("periodresult.format.screen"),
    CSV("periodresult.format.csv"),
    JSON("periodresult.format.json");

    @Getter private final String rbKey;

    PeriodResultFormat(@NonNull String rbKey) {
        this.rbKey = rbKey;
    }

}


