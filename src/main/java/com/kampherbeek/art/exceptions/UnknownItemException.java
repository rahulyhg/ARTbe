package com.kampherbeek.art.exceptions;

import lombok.Getter;
import lombok.NonNull;

public class UnknownItemException extends RuntimeException {

    @Getter
    private final String message;

    public UnknownItemException(@NonNull final String itemType, @NonNull String item) {
        message = String.format("Could not find %s, searched for: %s", itemType, item);
    }


}

