package com.kampherbeek.art.json.representation;

import com.kampherbeek.art.domain.CalculationPreferences;
import lombok.Getter;
import lombok.Setter;

public class BodyPositionRequest implements RequestInterface {

    @Getter @Setter
    private int internalId;
    @Getter @Setter
    private double jdnr;
    @Getter @Setter
    private CalculationPreferences calculationPreferences;

}
