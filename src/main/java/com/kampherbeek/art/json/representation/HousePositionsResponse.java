package com.kampherbeek.art.json.representation;

import com.kampherbeek.art.domain.HousePositions;
import lombok.Getter;
import lombok.NonNull;

public class HousePositionsResponse implements ResponseInterface {

    @Getter
    private final HousePositions positions;

    public HousePositionsResponse(@NonNull final HousePositions positions) {
        this.positions = positions;
    }

}
