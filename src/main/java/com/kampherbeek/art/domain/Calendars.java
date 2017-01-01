package com.kampherbeek.art.domain;

public enum Calendars {

    GREGORIAN(true),
    JULIAN(false);

    private boolean gregorianCal;

    Calendars(boolean gregorianCal) {
        this.gregorianCal = gregorianCal;
    }

    public boolean isGregorianCal() {
        return gregorianCal;
    }
}
