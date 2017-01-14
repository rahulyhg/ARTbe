package com.kampherbeek.art.json.representation;

import java.util.List;

public class BodySetPositionRequest implements RequestInterface {

    private double jdnr;
    private int flagValue;
    private List<Integer> internalIds;

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

    public List<Integer> getInternalIds() {
        return internalIds;
    }

    public void setInternalIds(List<Integer> internalIds) {
        this.internalIds = internalIds;
    }
}
