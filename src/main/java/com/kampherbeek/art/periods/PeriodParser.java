package com.kampherbeek.art.periods;

import com.kampherbeek.art.calc.se.SeFlags2IntCreator;
import com.kampherbeek.art.domain.CalculationPreferences;
import com.kampherbeek.art.domain.SingleCyclesMethod;
import com.kampherbeek.art.domain.SingleCyclesRow;
import com.kampherbeek.art.domain.SpeedResults;
import com.kampherbeek.art.json.representation.BodyPositionResponse;
import com.kampherbeek.art.json.representation.SingleCyclesRequest;
import com.kampherbeek.art.solvers.BodyPositionSolver;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeriodParser {

    private final BodyPositionSolver bodyPositionSolver;
    private final SeFlags2IntCreator seFlags2IntCreator;
    private final SpeedPeriodComparator comparator;
    private final static double stepSize = 5.0;
    private final static double minStepSize = 0.000005; // about 0.4 second

    public PeriodParser(@NonNull BodyPositionSolver bodyPositionSolver,
                        @NonNull SeFlags2IntCreator seFlags2IntCreator,
                        @NonNull SpeedPeriodComparator comparator) {
        this.bodyPositionSolver = bodyPositionSolver;
        this.seFlags2IntCreator = seFlags2IntCreator;
        this.comparator = comparator;
    }

    public List<SingleCyclesRow> lookForOccurrences(@NonNull SingleCyclesRequest request) {
        return parseIt(request);
    }

    private List<SingleCyclesRow> parseIt(@NonNull SingleCyclesRequest request) {
        int internalId = request.getInternalId();
        CalculationPreferences preferences = request.getCalculationPreferences();
        int combinedFlags =  seFlags2IntCreator.createFlags(preferences.getFlags());
        SingleCyclesMethod singleCyclesMethod = request.getSingleCyclesMethod();
        List<SingleCyclesRow> foundOccurrences = new ArrayList<>();
        double[] positions = new double[3];
        //        jdnrs initial
        double jdnrStart = request.getStartJdnr();
        double jdnrEnd = request.getEndJdnr();
        //        bepaal jdnrs
        double[] jdnrs = new double[3];
        jdnrs[0] = jdnrStart - stepSize;
        jdnrs[1] = jdnrStart;
        jdnrs[2] = jdnrStart + stepSize;
        BodyPositionResponse bodyPositionResponse;
        boolean moreData = true;
        boolean match = false;
        while (moreData) {
            for (int i = 0; i < 3; i++) {
                bodyPositionResponse = bodyPositionSolver.solveRequest(internalId, jdnrs[i], combinedFlags);
                positions[i] = retrieveValue(bodyPositionResponse, singleCyclesMethod);
            }
            SpeedResults result = comparator.defineResults(positions);
            if (result == SpeedResults.NONE) {
                jdnrs[0] = jdnrs[1];
                jdnrs[1] = jdnrs[2];
                jdnrs[2]+= stepSize;
                if (jdnrs[1] >= jdnrEnd) {
                    moreData = false;
                }
            } else {
                boolean drilldown = true;
                boolean moreTempData = true;
                double drillDownStepSize = stepSize;
                double[] drilldownJdnrs = new double[3];
                for (int i = 0; i < 3; i++) {
                    drilldownJdnrs[i] = jdnrs[i];
                }
                double drilldownMaxJdnr = jdnrs[2];
                while (drilldown) {
                    drillDownStepSize*= 0.1;
                    drilldownJdnrs[1] = drilldownJdnrs[0] + drillDownStepSize;
                    drilldownJdnrs[2] = drilldownJdnrs[1] + drillDownStepSize;
                    while (moreTempData) {
                        for (int i = 0; i < 3; i++) {
                            bodyPositionResponse = bodyPositionSolver.solveRequest(internalId, drilldownJdnrs[i], combinedFlags);
                            positions[i] = retrieveValue(bodyPositionResponse, singleCyclesMethod);
                        }
                        result = comparator.defineResults(positions);
                        if (result == SpeedResults.NONE) {
                            drilldownJdnrs[0] = drilldownJdnrs[1];
                            drilldownJdnrs[1] = drilldownJdnrs[2];
                            drilldownJdnrs[2] += drillDownStepSize;
                        } else {
                            if (drillDownStepSize >= minStepSize) {
                                drillDownStepSize*= 0.1;
                                drilldownJdnrs[1] = drilldownJdnrs[0] + drillDownStepSize;
                                drilldownJdnrs[2] = drilldownJdnrs[1] + drillDownStepSize;
                            } else {
                                SingleCyclesRow row = new SingleCyclesRow();
                                row.setDateTimeTxt("");   // TODO convert jdnr to datetime
                                row.setJdnr(drilldownJdnrs[1]);
                                row.setPosition(positions[1]);
                                row.setDescription(result.getRbIdDescription());   // TODO use data from rb
                                foundOccurrences.add(new SingleCyclesRow());
                                drilldown = false;
                            }
                        }
                    }  // while moreTempData
                }  // while (drilldown)
            }  // else if
        }  // while moreData
        return foundOccurrences;
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
