package com.kampherbeek.art.solvers;

import com.kampherbeek.art.calc.se.SEFrontend;
import com.kampherbeek.art.domain.HousePositions;
import com.kampherbeek.art.json.representation.HousePositionsRequest;
import com.kampherbeek.art.json.representation.HousePositionsResponse;
import org.springframework.stereotype.Component;

@Component
public class HousePositionsSolver {

    private final SEFrontend seFrontend;

    public HousePositionsSolver(SEFrontend seFrontend) {
        this.seFrontend = seFrontend;
    }

    public HousePositionsResponse solveRequest(HousePositionsRequest request) {

        HousePositions housePositions = seFrontend.calcHouses(request);
        return new HousePositionsResponse(housePositions);
    }



}
