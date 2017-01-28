package com.kampherbeek.art.domain;

import lombok.Getter;
import lombok.NonNull;

public class SimpleDateTime {

    @Getter
    private SimpleDate simpleDate;
    @Getter
    private SimpleTime simpleTime;

    public SimpleDateTime() {
        // default constructor for Json.
    }

    public SimpleDateTime(@NonNull SimpleDate simpleDate, @NonNull SimpleTime simpleTime) {
        this.simpleDate = simpleDate;
        this.simpleTime = simpleTime;
    }

}
