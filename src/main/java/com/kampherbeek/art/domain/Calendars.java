package com.kampherbeek.art.domain;

import lombok.Getter;

public enum Calendars {

    GREGORIAN(true),
    JULIAN(false);

    @Getter
    private final boolean gregorianCal;

    Calendars(boolean gregorianCal) {
        this.gregorianCal = gregorianCal;
    }

}
