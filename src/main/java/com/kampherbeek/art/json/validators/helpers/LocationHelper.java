package com.kampherbeek.art.json.validators.helpers;

import com.kampherbeek.art.domain.FloatingLimits;
import com.kampherbeek.art.domain.Location;
import org.springframework.stereotype.Component;

@Component
public class LocationHelper {

    private final ValueChecker valueChecker;

    public LocationHelper(ValueChecker valueChecker) {
        this.valueChecker = valueChecker;
    }

    public boolean isValid(Location location) {
        return valueChecker.checkValue(location.getLongitude(), FloatingLimits.LONGITUDE)
                && valueChecker.checkValue(location.getLatitude(), FloatingLimits.LATITUDE);
    }


}
