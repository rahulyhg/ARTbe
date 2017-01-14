package com.kampherbeek.art.json.representation;

import java.util.List;

public class BodySetPositionResponse implements ResponseInterface {

    private final List<BodyPositionResponse> positions;

    public BodySetPositionResponse(List<BodyPositionResponse> positions) {
        this.positions = positions;
    }

    public List<BodyPositionResponse> getPositions() {
        return positions;
    }
}
