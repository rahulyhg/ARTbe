package com.kampherbeek.art.json.representation;

import lombok.Getter;
import lombok.NonNull;

import java.util.List;

public class BodySetPositionResponse implements ResponseInterface {

    @Getter
    private final List<BodyPositionResponse> positions;

    public BodySetPositionResponse(@NonNull final List<BodyPositionResponse> positions) {
        this.positions = positions;
    }

}
