package com.kampherbeek.art.json.representation;

import java.util.List;

public class BodynamesResponse implements ResponseInterface {

    private final List<StandardSelectionItem> bodynames;

    public BodynamesResponse(List<StandardSelectionItem> bodynames) {
        this.bodynames = bodynames;
    }

    public List<StandardSelectionItem> getBodynames() {
        return bodynames;
    }
}
