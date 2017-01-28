package com.kampherbeek.art.json.representation;

import lombok.Getter;
import lombok.NonNull;

import java.util.List;

public class HouseSystemsResponse implements ResponseInterface {

    @Getter
    private final List<StandardSelectionItem> houseSystems;

    public HouseSystemsResponse(@NonNull final List<StandardSelectionItem> houseSystems) {
        this.houseSystems = houseSystems;
    }

}
