package com.kampherbeek.art.solvers;

import com.kampherbeek.art.json.representation.*;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculatedChartSolver {

    private final JdnrSolver jdnrSolver;
    private final BodySetPositionSolver bodySetPositionSolver;
    private final HousePositionsSolver housePositionsSolver;

    @Autowired
    public CalculatedChartSolver(@NonNull final JdnrSolver jdnrSolver,
                                 @NonNull final BodySetPositionSolver bodySetPositionSolver,
                                 @NonNull final HousePositionsSolver housePositionsSolver) {
        this.jdnrSolver = jdnrSolver;
        this.bodySetPositionSolver = bodySetPositionSolver;
        this.housePositionsSolver = housePositionsSolver;
    }

    public CalculatedChartResponse solveRequest(@NonNull final CalculatedChartRequest chartRequest) {
        JdnrRequest jdnrRequest = createJdnrRequest(chartRequest);
        double jdnr = jdnrSolver.solveRequest(jdnrRequest).getJdnr();
        BodySetPositionRequest bodySetPositionRequest = createBodySetPositionRequest(chartRequest, jdnr);
        BodySetPositionResponse bodySetPositionResponse = bodySetPositionSolver.solveRequest(bodySetPositionRequest);
        HousePositionsRequest housePositionsRequest = createHousePositionsRequest(chartRequest, jdnr);
        HousePositionsResponse housePositionsResponse = housePositionsSolver.solveRequest(housePositionsRequest);
        return new CalculatedChartResponse(bodySetPositionResponse, housePositionsResponse);
    }

    private BodySetPositionRequest createBodySetPositionRequest(@NonNull final CalculatedChartRequest chartRequest,
                                                                final double jdnr) {
        BodySetPositionRequest bodySetPositionRequest = new BodySetPositionRequest();
        bodySetPositionRequest.setCalculationPreferences(chartRequest.getCalculationPreferences());
        bodySetPositionRequest.setJdnr(jdnr);
        bodySetPositionRequest.setInternalIds(chartRequest.getBodyIds());
        return bodySetPositionRequest;
    }

    private HousePositionsRequest createHousePositionsRequest(@NonNull final CalculatedChartRequest chartRequest,
                                                              final double jdnr) {
        HousePositionsRequest housePositionsRequest = new HousePositionsRequest();
        housePositionsRequest.setLocation(chartRequest.getLocation());
        housePositionsRequest.setJdnr(jdnr);
        housePositionsRequest.setSystem(chartRequest.getHouseSystemId());
        return housePositionsRequest;
    }

    private JdnrRequest createJdnrRequest(@NonNull final CalculatedChartRequest chartRequest) {
        JdnrRequest jdnrRequest = new JdnrRequest();
        jdnrRequest.setSimpleDateTime(chartRequest.getSimpleDateTime());
        return jdnrRequest;
    }
}
