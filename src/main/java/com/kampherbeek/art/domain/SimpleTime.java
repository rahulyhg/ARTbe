package com.kampherbeek.art.domain;

public class SimpleTime {

    private int hour;
    private int minute;
    private int second;

    public SimpleTime() {
        // default constructor for Json.
    }

    public SimpleTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }
}
