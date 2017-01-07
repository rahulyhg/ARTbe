package com.kampherbeek.art.solvers;

import com.kampherbeek.art.calc.se.SEFrontend;
import com.kampherbeek.art.domain.BodyPosition;
import com.kampherbeek.art.domain.Bodynames;
import com.kampherbeek.art.json.representation.BodyPositionRequest;
import com.kampherbeek.art.json.representation.BodyPositionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BodyPositionSolver {

    private final SEFrontend seFrontend;
    private static final Logger LOG = LoggerFactory.getLogger(BodyPositionSolver.class);

    public BodyPositionSolver(SEFrontend seFrontend) {
        this.seFrontend = seFrontend;
    }

    public BodyPositionResponse solveRequest(BodyPositionRequest request) {
        BodyPosition bodyPosition = seFrontend.calcBody(request);
        Bodynames bodyname = getBodyname4Id(request.getInternalId());
        return new BodyPositionResponse(bodyname, bodyPosition);
    }

    private Bodynames getBodyname4Id(int id) {
        for (Bodynames name: Bodynames.values()) {
            if (name.getInternalId() == id) {
                return name;
            }
        }
        String error = "Could not find body: " + id;
        LOG.error(error);
        throw new RuntimeException(error);
    }
}



/*


    public HousePositionsResponse solveRequest(HousePositionsRequest request) {

        HousePositions housePositions = seFrontend.calcHouses(request);
        return new HousePositionsResponse(housePositions);
    }


 */