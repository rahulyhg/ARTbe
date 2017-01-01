package com.kampherbeek.art.calc.se;

import com.kampherbeek.art.domain.CalculationFlags;
import com.kampherbeek.art.domain.HousePositions;
import com.kampherbeek.art.json.representation.HousePositionsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import swisseph.SwissEph;

@Component
public class SEFrontend {

//    private static final SEFrontend oneAndOnlyInstance = new SEFrontend();
    private SwissEph swissEph;
//    private BodyPositionCalculator bodyCalculator;
    private final HousePositionsCalculator housesCalculator;


    @Autowired
    public SEFrontend(HousePositionsCalculator housesCalculator) {
        this.housesCalculator = housesCalculator;
        swissEph = new SwissEph();
        housesCalculator.setSwissEph(swissEph);


    }

//    static SEFrontend getSEFrontEnd() {
//        return oneAndOnlyInstance;
//    }

//    public void setSwissEph(SwissEph swissEph) {
//        this.swissEph = swissEph;
//    }

//    public void setBodyCalculator(BodyPositionCalculator bodyCalculator) {
//        this.bodyCalculator = bodyCalculator;
//    }

//    public void setHousesCalculator(HousePositionsCalculator housesCalculator) {
//        this.housesCalculator = housesCalculator;
//    }


//    public BodyPosition calcBody(CalculationRequestBody request) {
//        double julianDayNr = calcJd(request.getSimpleDateTime());
//        int flagValue = constructCombinedValueForFlags(request.getCalculationFlags());
//        return bodyCalculator.calcBody(request.getBodyName(), julianDayNr, flagValue);
//    }



    public HousePositions calcHouses(HousePositionsRequest request) {
        int flagValue =  CalculationFlags.SWIEPH.getFlagId();
        return housesCalculator.calcHouses(request.getSystem(), request.getLocation(), request.getJdnr(), flagValue);
    }

}

