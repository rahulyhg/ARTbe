package com.kampherbeek.art.json.representation;

import lombok.Getter;
import lombok.NonNull;

import java.util.List;

public class BodynamesResponse implements ResponseInterface {

    @Getter
    private final List<StandardSelectionItem> bodynames;

    public BodynamesResponse(@NonNull final List<StandardSelectionItem> bodynames) {
        this.bodynames = bodynames;
    }

}
