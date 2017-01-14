package com.kampherbeek.art.json.representation;

import com.kampherbeek.art.domain.Location;

public class HousePositionsRequest implements RequestInterface {

    private int system;
    private double jdnr;
    private Location location;

    public int getSystem() {
        return system;
    }

    public void setSystem(int system) {
        this.system = system;
    }

    public double getJdnr() {
        return jdnr;
    }

    public void setJdnr(double jdnr) {
        this.jdnr = jdnr;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
