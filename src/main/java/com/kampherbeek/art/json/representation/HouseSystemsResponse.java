package com.kampherbeek.art.json.representation;

import java.util.List;

public class HouseSystemsResponse implements ResponseInterface {

    private final List<StandardSelectionItem> houseSystems;

    public HouseSystemsResponse(List<StandardSelectionItem> houseSystems) {
        this.houseSystems = houseSystems;
    }

    public List<StandardSelectionItem> getHouseSystems() {
        return houseSystems;
    }
}
