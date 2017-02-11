package com.kampherbeek.art.solvers;

import com.kampherbeek.art.calc.se.SEFrontend;
import com.kampherbeek.art.domain.BodyPosition;
import com.kampherbeek.art.domain.Bodynames;
import com.kampherbeek.art.domain.CalculationFlags;
import com.kampherbeek.art.domain.CalculationPreferences;
import com.kampherbeek.art.json.representation.BodyPositionRequest;
import com.kampherbeek.art.json.representation.EpsilonRequest;
import com.kampherbeek.art.json.representation.EpsilonResponse;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EpsilonSolver {

    private final SEFrontend seFrontend;

    public EpsilonSolver(@NonNull final SEFrontend seFrontend) {
        this.seFrontend = seFrontend;
    }

    public EpsilonResponse solveRequest(@NonNull final EpsilonRequest request) {
        BodyPositionRequest bodyRequest = new BodyPositionRequest();
        bodyRequest.setCalculationPreferences(constructPreferences());
        bodyRequest.setInternalId(Bodynames.EPSILON.getInternalId());
        bodyRequest.setJdnr(request.getJdnr());
        BodyPosition bodyPosition = seFrontend.calcBody(bodyRequest);
        EpsilonResponse response = new EpsilonResponse();
        response.setEpsilon(bodyPosition.getCoordinates().getMainValue());
        return response;
    }

    private CalculationPreferences constructPreferences() {
        List<CalculationFlags> flags = new ArrayList<>();
        return new CalculationPreferences(flags);
    }
}

