package com.kampherbeek.art.json;

import lombok.Getter;
import lombok.NonNull;

public class ValidatedObject {

    @Getter
    private final boolean isValid;
    @Getter
    private final Object object;

    public ValidatedObject(final boolean isValid, @NonNull final Object object) {
        this.isValid = isValid;
        this.object = object;
    }

}
