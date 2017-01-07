package com.kampherbeek.art.json.representation;

public class BodyPositionRequest implements RequestInterface {

    private int internalId;
    private double jdnr;
    private int flagValue;

    public int getInternalId() {
        return internalId;
    }

    public void setInternalId(int internalId) {
        this.internalId = internalId;
    }

    public double getJdnr() {
        return jdnr;
    }

    public void setJdnr(double jdnr) {
        this.jdnr = jdnr;
    }

    public int getFlagValue() {
        return flagValue;
    }

    public void setFlagValue(int flagValue) {
        this.flagValue = flagValue;
    }
}
