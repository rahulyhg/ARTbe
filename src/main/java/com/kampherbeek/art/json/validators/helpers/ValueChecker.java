package com.kampherbeek.art.json.validators.helpers;

import com.kampherbeek.art.domain.FloatingLimits;
import com.kampherbeek.art.domain.IntegerLimits;
import org.springframework.stereotype.Component;

@Component
public class ValueChecker {

    public boolean checkValue(int value, IntegerLimits limits) {
        return value >= limits.getMinValue() && value <= limits.getMaxValue();
    }

    public boolean checkValue(double value, FloatingLimits limits) {
        return value >= limits.getMinValue() && value <= limits.getMaxValue();
    }

}
