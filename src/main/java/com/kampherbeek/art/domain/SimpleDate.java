package com.kampherbeek.art.domain;

import lombok.Getter;

public class SimpleDate {
    @Getter
    private int year;
    @Getter
    private int month;
    @Getter
    private int day;
    @Getter
    private boolean gregorian;

    public SimpleDate() {
        // default constructor for Json.
    }

    public SimpleDate(int year, int month, int day, boolean gregorian) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.gregorian = gregorian;
    }

}
