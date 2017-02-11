package com.kampherbeek.art.json.representation;

import com.kampherbeek.art.domain.CalculationPreferences;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class BodySetPositionRequest implements RequestInterface {

    @Getter
    @Setter
    private double jdnr;
    @Getter
    @Setter
    private CalculationPreferences calculationPreferences;
    @Getter
    @Setter
    private List<Integer> internalIds;
}
