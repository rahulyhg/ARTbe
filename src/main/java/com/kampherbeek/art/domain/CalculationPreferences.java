package com.kampherbeek.art.domain;

import lombok.Getter;
import lombok.NonNull;

import java.util.List;

/**
 * Preferences for calculations.
 */
public class CalculationPreferences {

    @Getter
    private final List<CalculationFlags> flags;

    public CalculationPreferences(@NonNull List<CalculationFlags> flags) {
        this.flags = flags;
    }




}
