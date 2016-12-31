package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.domain.Limits;
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
        return jdnr >= Limits.MIN_JULIAN_DAY_NR.getValue() && jdnr <= Limits.MAX_JULIAN_DAY_NR.getValue();
    }

    private boolean locationIsValid(Location location) {
        return location.getLongitude() >= Limits.MIN_LONGITUDE.getValue()
                && location.getLongitude() <= Limits.MAX_LONGITUDE.getValue()
                && location.getLatitude() >= Limits.MIN_LATITUDE.getValue()
                && location.getLatitude() <= Limits.MAX_LATITUDE.getValue();
    }
}
