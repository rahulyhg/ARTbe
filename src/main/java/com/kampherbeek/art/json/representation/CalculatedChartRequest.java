package com.kampherbeek.art.json.representation;

import com.kampherbeek.art.domain.Location;
import com.kampherbeek.art.domain.SimpleDateTime;

import java.util.List;

public class CalculatedChartRequest implements RequestInterface {

    private SimpleDateTime simpleDateTime;
    private Location location;
    private int flagValue;
    private int houseSystemId;
    private List<Integer> bodyIds;

    public SimpleDateTime getSimpleDateTime() {
        return simpleDateTime;
    }

    public void setSimpleDateTime(SimpleDateTime simpleDateTime) {
        this.simpleDateTime = simpleDateTime;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getFlagValue() {
        return flagValue;
    }

    public void setFlagValue(int flagValue) {
        this.flagValue = flagValue;
    }

    public int getHouseSystemId() {
        return houseSystemId;
    }

    public void setHouseSystemId(int houseSystemId) {
        this.houseSystemId = houseSystemId;
    }

    public List<Integer> getBodyIds() {
        return bodyIds;
    }

    public void setBodyIds(List<Integer> bodyIds) {
        this.bodyIds = bodyIds;
    }
}
