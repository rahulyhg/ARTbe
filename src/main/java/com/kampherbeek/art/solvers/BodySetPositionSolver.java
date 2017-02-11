package com.kampherbeek.art.solvers;

import com.kampherbeek.art.domain.CalculationPreferences;
import com.kampherbeek.art.json.representation.BodyPositionRequest;
import com.kampherbeek.art.json.representation.BodyPositionResponse;
import com.kampherbeek.art.json.representation.BodySetPositionRequest;
import com.kampherbeek.art.json.representation.BodySetPositionResponse;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BodySetPositionSolver {

    private final BodyPositionSolver bodyPositionSolver;

    @Autowired
    public BodySetPositionSolver(@NonNull final BodyPositionSolver bodyPositionSolver) {
        this.bodyPositionSolver = bodyPositionSolver;
    }

    public BodySetPositionResponse solveRequest(@NonNull final BodySetPositionRequest bodySetPositionRequest) {
        BodyPositionRequest bodyPositionRequest = createBodyPositionRequest(bodySetPositionRequest.getJdnr(),
                bodySetPositionRequest.getCalculationPreferences());
        List<BodyPositionResponse> allBodyPositions = new ArrayList<>();
        for (int internalId : bodySetPositionRequest.getInternalIds()) {
            bodyPositionRequest.setInternalId(internalId);
            allBodyPositions.add(bodyPositionSolver.solveRequest(bodyPositionRequest));
        }
        return new BodySetPositionResponse(allBodyPositions);
    }

    private BodyPositionRequest createBodyPositionRequest(final double jdnr,
                                                          @NonNull final CalculationPreferences calculationPreferences) {
        BodyPositionRequest request = new BodyPositionRequest();
        request.setJdnr(jdnr);
        request.setCalculationPreferences(calculationPreferences);
        return request;
    }
}
