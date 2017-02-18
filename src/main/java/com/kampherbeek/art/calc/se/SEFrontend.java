package com.kampherbeek.art.calc.se;

import com.kampherbeek.art.domain.BodyPosition;
import com.kampherbeek.art.domain.CalculationFlags;
import com.kampherbeek.art.domain.HousePositions;
import com.kampherbeek.art.json.representation.BodyPositionRequest;
import com.kampherbeek.art.json.representation.HousePositionsRequest;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import swisseph.SwissEph;

@Component
public class SEFrontend {

    private final SwissEph swissEph;
    private final BodyPositionCalculator bodyCalculator;
    private final HousePositionsCalculator housesCalculator;
    private final SeFlags2IntCreator seFlags2IntCreator;

    @Autowired
    public SEFrontend(@NonNull HousePositionsCalculator housesCalculator,
                      @NonNull BodyPositionCalculator bodyCalculator,
                      @NonNull SeFlags2IntCreator seFlags2IntCreator) {
        this.housesCalculator = housesCalculator;
        this.bodyCalculator = bodyCalculator;
        this.seFlags2IntCreator = seFlags2IntCreator;
        swissEph = new SwissEph();
        housesCalculator.setSwissEph(swissEph);
        bodyCalculator.setSwissEph(swissEph);
    }

    public HousePositions calcHouses(@NonNull HousePositionsRequest request) {
        int flagValue = CalculationFlags.SWIEPH.getFlagId();
        return housesCalculator.calcHouses(request.getSystem(), request.getLocation(), request.getJdnr(), flagValue);
    }

    public BodyPosition calcBody(@NonNull BodyPositionRequest request) {
        int flags = seFlags2IntCreator.createFlags(request.getCalculationPreferences().getFlags());
        return bodyCalculator.calcBody(request.getInternalId(), request.getJdnr(), flags);
    }

    public BodyPosition calcBody(int internalId, double jdnr, int flags) {
        return bodyCalculator.calcBody(internalId, jdnr, flags);
    }
}

