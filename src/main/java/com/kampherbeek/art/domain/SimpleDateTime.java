package com.kampherbeek.art.domain;

public class SimpleDateTime {

    private SimpleDate simpleDate;
    private SimpleTime simpleTime;

    public SimpleDateTime() {
        // default constructor for Json.
    }

    public SimpleDateTime(SimpleDate simpleDate, SimpleTime simpleTime) {
        this.simpleDate = simpleDate;
        this.simpleTime = simpleTime;
    }

    public SimpleDate getSimpleDate() {
        return simpleDate;
    }

    public SimpleTime getSimpleTime() {
        return simpleTime;
    }
}
