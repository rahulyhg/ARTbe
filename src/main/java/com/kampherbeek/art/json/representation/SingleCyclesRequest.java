package com.kampherbeek.art.json.representation;

import com.kampherbeek.art.domain.CalculationPreferences;
import com.kampherbeek.art.domain.PeriodResultFormat;
import com.kampherbeek.art.domain.SingleCyclesMethod;
import lombok.Getter;
import lombok.Setter;

public class SingleCyclesRequest implements RequestInterface {

    @Getter @Setter
    private int internalId;
    @Getter @Setter
    private double startJdnr;
    @Getter @Setter
    private double endJdnr;
    @Getter @Setter
    private CalculationPreferences calculationPreferences;
    @Getter @Setter
    private PeriodResultFormat periodResultFormat;
    @Getter @Setter
    private SingleCyclesMethod singleCyclesMethod;
    @Getter @Setter
    private String locale;
}
