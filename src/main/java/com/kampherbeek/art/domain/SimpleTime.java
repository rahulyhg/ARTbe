package com.kampherbeek.art.domain;

import lombok.Getter;

public class SimpleTime {

    @Getter
    private int hour;
    @Getter
    private int minute;
    @Getter
    private int second;

    public SimpleTime() {
        // default constructor for Json.
    }

    public SimpleTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
}
