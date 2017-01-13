package com.kampherbeek.art.domain;

public class SimpleDate {
    private int year;
    private int month;
    private int day;
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

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public boolean isGregorian() {
        return gregorian;
    }
}
