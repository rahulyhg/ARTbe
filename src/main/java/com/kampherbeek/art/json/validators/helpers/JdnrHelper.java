package com.kampherbeek.art.json.validators.helpers;

import com.kampherbeek.art.domain.FloatingLimits;
import org.springframework.stereotype.Component;

@Component
public class JdnrHelper {

    public boolean checkJdnrValid(double jdnr) {
        return jdnr >= FloatingLimits.JULIAN_DAY_NR.getMinValue() && jdnr <= FloatingLimits.JULIAN_DAY_NR.getMaxValue();
    }
}
