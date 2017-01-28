package com.kampherbeek.art.json.validators.helpers;

import com.kampherbeek.art.domain.FloatingLimits;
import com.kampherbeek.art.domain.Location;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class LocationHelper {

    private final ValueChecker valueChecker;

    public LocationHelper(@NonNull final ValueChecker valueChecker) {
        this.valueChecker = valueChecker;
    }

    public boolean checkLocationValid(@NonNull final Location location) {
        return valueChecker.checkValue(location.getLongitude(), FloatingLimits.LONGITUDE)
                && valueChecker.checkValue(location.getLatitude(), FloatingLimits.LATITUDE);
    }
}
