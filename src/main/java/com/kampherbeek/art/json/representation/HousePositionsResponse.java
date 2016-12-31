package com.kampherbeek.art.json.representation;

import com.kampherbeek.art.domain.HousePositions;

public class HousePositionsResponse implements ResponseInterface {

    private final HousePositions positions;

    public HousePositionsResponse(HousePositions positions) {
        this.positions = positions;
    }

    public HousePositions getPositions() {
        return positions;
    }
}
