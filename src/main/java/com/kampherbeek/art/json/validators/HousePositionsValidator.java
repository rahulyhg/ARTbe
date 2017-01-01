package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.domain.FloatingLimits;
import com.kampherbeek.art.domain.Location;
import com.kampherbeek.art.json.representation.HousePositionsRequest;
import com.kampherbeek.art.json.representation.RequestInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HousePositionsValidator extends ValidatorParent {

    private static final Logger LOG = LoggerFactory.getLogger(HousePositionsValidator.class);

    @Override
    protected boolean isValid(RequestInterface request) {
        try {
            HousePositionsRequest hpRequest = (HousePositionsRequest)request;
            return (jdnrIsValid(hpRequest.getJdnr())) && (locationIsValid(hpRequest.getLocation()));
        } catch (Exception e) {
            LOG.error("Exception: " + e.getMessage());
            return false;
        }
    }

    private boolean jdnrIsValid(double jdnr) {
        return jdnr >= FloatingLimits.MIN_JULIAN_DAY_NR.getValue() && jdnr <= FloatingLimits.MAX_JULIAN_DAY_NR.getValue();
    }

    private boolean locationIsValid(Location location) {
        return location.getLongitude() >= FloatingLimits.MIN_LONGITUDE.getValue()
                && location.getLongitude() <= FloatingLimits.MAX_LONGITUDE.getValue()
                && location.getLatitude() >= FloatingLimits.MIN_LATITUDE.getValue()
                && location.getLatitude() <= FloatingLimits.MAX_LATITUDE.getValue();
    }
}
