package com.kampherbeek.art.solvers;

import com.kampherbeek.art.calc.se.SEFrontend;
import com.kampherbeek.art.json.representation.BodyPositionRequest;
import com.kampherbeek.art.json.representation.BodyPositionResponse;
import com.kampherbeek.art.json.representation.BodySetPositionRequest;
import com.kampherbeek.art.json.representation.BodySetPositionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BodySetPositionSolver {

    private final SEFrontend seFrontend;
    private final BodyPositionSolver bodyPositionSolver;
    private static final Logger LOG = LoggerFactory.getLogger(BodySetPositionSolver.class);

    public BodySetPositionSolver(SEFrontend seFrontend, BodyPositionSolver bodyPositionSolver) {
        this.seFrontend = seFrontend;
        this.bodyPositionSolver = bodyPositionSolver;
    }

    public BodySetPositionResponse solveRequest(BodySetPositionRequest request) {
        List<BodyPositionResponse> allBodyPositions = new ArrayList<>();
        double jdnr = request.getJdnr();
        int flagValue = request.getFlagValue();
        BodyPositionRequest bodyPositionRequest = new BodyPositionRequest();
        bodyPositionRequest.setJdnr(jdnr);
        bodyPositionRequest.setFlagValue(flagValue);
        List<Integer> internalIds = request.getInternalIds();
        for (int internalId : internalIds) {
            bodyPositionRequest.setInternalId(internalId);
            allBodyPositions.add(bodyPositionSolver.solveRequest(bodyPositionRequest));
        }
        return new BodySetPositionResponse(allBodyPositions);
    }

}
