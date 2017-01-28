package com.kampherbeek.art.json.validators.helpers;

import com.kampherbeek.art.domain.FloatingLimits;
import com.kampherbeek.art.domain.IntegerLimits;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ValueChecker {

    public boolean checkValue(final int value, @NonNull final IntegerLimits limits) {
        return value >= limits.getMinValue() && value <= limits.getMaxValue();
    }

    public boolean checkValue(final double value, @NonNull final FloatingLimits limits) {
        return value >= limits.getMinValue() && value <= limits.getMaxValue();
    }
}
