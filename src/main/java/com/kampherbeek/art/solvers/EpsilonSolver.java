package com.kampherbeek.art.solvers;

import com.kampherbeek.art.calc.se.SEFrontend;
import com.kampherbeek.art.domain.BodyPosition;
import com.kampherbeek.art.domain.Bodynames;
import com.kampherbeek.art.json.representation.BodyPositionRequest;
import com.kampherbeek.art.json.representation.EpsilonRequest;
import com.kampherbeek.art.json.representation.EpsilonResponse;
import org.springframework.stereotype.Component;

@Component
public class EpsilonSolver {

    private final SEFrontend seFrontend;

    public EpsilonSolver(SEFrontend seFrontend) {
        this.seFrontend = seFrontend;
    }

    public EpsilonResponse solveRequest(EpsilonRequest request) {
        BodyPositionRequest bodyRequest = new BodyPositionRequest();
        bodyRequest.setFlagValue(0);
        bodyRequest.setInternalId(Bodynames.EPSILON.getInternalId());
        bodyRequest.setJdnr(request.getJdnr());
        BodyPosition bodyPosition = seFrontend.calcBody(bodyRequest);
        EpsilonResponse response = new EpsilonResponse();
        response.setEpsilon(bodyPosition.getCoordinates().getMainValue());
        return response;
    }
}

