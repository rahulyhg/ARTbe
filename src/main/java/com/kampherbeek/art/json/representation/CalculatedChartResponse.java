package com.kampherbeek.art.json.representation;

public class CalculatedChartResponse implements ResponseInterface {

    private final BodySetPositionResponse bodySetPositionResponse;
    private final HousePositionsResponse housePositionsResponse;

    public CalculatedChartResponse(BodySetPositionResponse bodySetPositionResponse,
                                   HousePositionsResponse housePositionsResponse) {
        this.bodySetPositionResponse = bodySetPositionResponse;
        this.housePositionsResponse = housePositionsResponse;
    }

    public BodySetPositionResponse getBodySetPositionResponse() {
        return bodySetPositionResponse;
    }

    public HousePositionsResponse getHousePositionsResponse() {
        return housePositionsResponse;
    }
}
