package com.kampherbeek.art.domain;

import lombok.Getter;

public enum SpeedResults {
    NONE("period.results.none"),
    RETRO_START("period.results.retro"),
    DIRECT_START("period.results.direct"),
    MAXIMUM("period.results.max"),
    MINIMUM("period.results.min");

    @Getter
    private String rbIdDescription;

    SpeedResults(String rbIdDescription) {
        this.rbIdDescription =rbIdDescription;
    }

}
