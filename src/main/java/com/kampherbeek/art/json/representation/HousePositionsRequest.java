package com.kampherbeek.art.json.representation;

import com.kampherbeek.art.domain.HouseSystems;
import com.kampherbeek.art.domain.Location;

public class HousePositionsRequest implements RequestInterface{

    private HouseSystems system;
    private double jdnr;
    private Location location;

    public HouseSystems getSystem() {
        return system;
    }

    public void setSystem(HouseSystems system) {
        this.system = system;
    }

    public double getJdnr() {
        return jdnr;
    }

    public void setJdnr(double jdnr) {
        this.jdnr = jdnr;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    public Location getLocation() {
        return location;
    }
}
