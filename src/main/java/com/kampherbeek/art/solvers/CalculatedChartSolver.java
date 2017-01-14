package com.kampherbeek.art.solvers;

import com.kampherbeek.art.json.representation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CalculatedChartSolver {

    private final JdnrSolver jdnrSolver;
    private final BodySetPositionSolver bodySetPositionSolver;
    private final HousePositionsSolver housePositionsSolver;

    @Autowired
    public CalculatedChartSolver(JdnrSolver jdnrSolver,
                                 BodySetPositionSolver bodySetPositionSolver,
                                 HousePositionsSolver housePositionsSolver) {
        this.jdnrSolver = jdnrSolver;
        this.bodySetPositionSolver = bodySetPositionSolver;
        this.housePositionsSolver = housePositionsSolver;
    }

    public CalculatedChartResponse solveRequest(CalculatedChartRequest chartRequest) {
        JdnrRequest jdnrRequest = createJdnrRequest(chartRequest);
        double jdnr = jdnrSolver.solveRequest(jdnrRequest).getJdnr();
        BodySetPositionRequest bodySetPositionRequest = createBodySetPositionRequest(chartRequest, jdnr);
        BodySetPositionResponse bodySetPositionResponse = bodySetPositionSolver.solveRequest(bodySetPositionRequest);
        HousePositionsRequest housePositionsRequest = createHousePositionsRequest(chartRequest, jdnr);
        HousePositionsResponse housePositionsResponse = housePositionsSolver.solveRequest(housePositionsRequest);
        return new CalculatedChartResponse(bodySetPositionResponse, housePositionsResponse);
    }

    private BodySetPositionRequest createBodySetPositionRequest(CalculatedChartRequest chartRequest, double jdnr) {
        BodySetPositionRequest bodySetPositionRequest = new BodySetPositionRequest();
        bodySetPositionRequest.setFlagValue(chartRequest.getFlagValue());
        bodySetPositionRequest.setJdnr(jdnr);
        bodySetPositionRequest.setInternalIds(chartRequest.getBodyIds());
        return bodySetPositionRequest;
    }

    private HousePositionsRequest createHousePositionsRequest(CalculatedChartRequest chartRequest, double jdnr) {
        HousePositionsRequest housePositionsRequest = new HousePositionsRequest();
        housePositionsRequest.setLocation(chartRequest.getLocation());
        housePositionsRequest.setJdnr(jdnr);
        housePositionsRequest.setSystem(chartRequest.getHouseSystemId());
        return housePositionsRequest;
    }

    private JdnrRequest createJdnrRequest(CalculatedChartRequest chartRequest) {
        JdnrRequest jdnrRequest = new JdnrRequest();
        jdnrRequest.setSimpleDateTime(chartRequest.getSimpleDateTime());
        return jdnrRequest;
    }
}
