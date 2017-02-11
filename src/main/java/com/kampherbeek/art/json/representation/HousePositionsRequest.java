package com.kampherbeek.art.json.representation;

import com.kampherbeek.art.domain.CalculationPreferences;
import com.kampherbeek.art.domain.Location;
import lombok.Getter;
import lombok.Setter;

public class HousePositionsRequest implements RequestInterface {

    @Getter
    @Setter
    private int system;
    @Getter
    @Setter
    private double jdnr;
    @Getter
    @Setter
    private Location location;
    @Getter
    @Setter
    private CalculationPreferences calculationPreferences;

}
