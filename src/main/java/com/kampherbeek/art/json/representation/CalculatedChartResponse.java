package com.kampherbeek.art.json.representation;

import lombok.Getter;
import lombok.NonNull;

public class CalculatedChartResponse implements ResponseInterface {

    @Getter
    private final BodySetPositionResponse bodySetPositionResponse;
    @Getter
    private final HousePositionsResponse housePositionsResponse;

    public CalculatedChartResponse(@NonNull final BodySetPositionResponse bodySetPositionResponse,
                                   @NonNull final HousePositionsResponse housePositionsResponse) {
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
