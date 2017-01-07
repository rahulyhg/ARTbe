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
        return jdnr >= FloatingLimits.JULIAN_DAY_NR.getMinValue() && jdnr <= FloatingLimits.JULIAN_DAY_NR.getMaxValue();
    }

    private boolean locationIsValid(Location location) {
        return location.getLongitude() >= FloatingLimits.LONGITUDE.getMinValue()
                && location.getLongitude() <= FloatingLimits.LONGITUDE.getMaxValue()
                && location.getLatitude() >= FloatingLimits.LATITUDE.getMinValue()
                && location.getLatitude() <= FloatingLimits.LATITUDE.getMaxValue();
    }
}
