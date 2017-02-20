package com.kampherbeek.art.periods;

import com.kampherbeek.art.calc.se.SeFlags2IntCreator;
import com.kampherbeek.art.domain.CalculationPreferences;
import com.kampherbeek.art.domain.SingleCyclesMethod;
import com.kampherbeek.art.json.representation.BodyPositionResponse;
import com.kampherbeek.art.json.representation.SingleCyclesRequest;
import com.kampherbeek.art.solvers.BodyPositionSolver;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeriodValueDefiner {

    private final BodyPositionSolver bodyPositionSolver;
    private final SeFlags2IntCreator seFlags2IntCreator;

    @Autowired
    public PeriodValueDefiner(@NonNull BodyPositionSolver bodyPositionSolver,
                              @NonNull SeFlags2IntCreator seFlags2IntCreator) {
        this.bodyPositionSolver = bodyPositionSolver;
        this.seFlags2IntCreator = seFlags2IntCreator;
    }

    public List<Double[]> defineValues(@NonNull List<Double> allJdnrs, @NonNull SingleCyclesRequest request) {
        BodyPositionResponse response;
        List<Double[]> foundValues = new ArrayList<>();
        CalculationPreferences preferences = request.getCalculationPreferences();
        int combinedFlags =  seFlags2IntCreator.createFlags(preferences.getFlags());
        int internalId = request.getInternalId();
        SingleCyclesMethod singleCyclesMethod = request.getSingleCyclesMethod();
        for (double actJdnr : allJdnrs) {
            response = bodyPositionSolver.solveRequest(internalId, actJdnr, combinedFlags);
            double value = retrieveValue(response, singleCyclesMethod);
            Double[] jdnrValue = {actJdnr, value};
            foundValues.add(jdnrValue);
        }
        return foundValues;
    }

    private double retrieveValue(@NonNull BodyPositionResponse bodyPositionResponse,
                                 @NonNull SingleCyclesMethod singleCyclesMethod) {
        switch (singleCyclesMethod) {
            case DISTANCE: return bodyPositionResponse.getPosition().getCoordinates().getDistance();
            case POSITION: return bodyPositionResponse.getPosition().getCoordinates().getMainValue();
            case DEVIATION: return bodyPositionResponse.getPosition().getSpeed().getDeviation();
            case SPEED: return bodyPositionResponse.getPosition().getSpeed().getMainValue();
            default: throw new RuntimeException("Unknown value for SingleCyclesMethod");
        }
    }

}
