package com.kampherbeek.art.json.representation;

import lombok.Getter;
import lombok.NonNull;

public class StandardSelectionItem {

    @Getter
    private final String id;
    @Getter
    private final String value;

    public StandardSelectionItem(@NonNull final String id, @NonNull final String value) {
        this.id = id;
        this.value = value;
    }

}
