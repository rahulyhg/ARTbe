package com.kampherbeek.art;

public enum TestConstants {
    DOUBLE_MARGIN(0.00000000);

    final double value;

    TestConstants(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
