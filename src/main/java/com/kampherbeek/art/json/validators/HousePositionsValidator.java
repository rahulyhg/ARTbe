package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.json.representation.HousePositionsRequest;
import com.kampherbeek.art.json.representation.RequestInterface;
import com.kampherbeek.art.json.validators.helpers.JdnrHelper;
import com.kampherbeek.art.json.validators.helpers.LocationHelper;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HousePositionsValidator extends ValidatorParent {

    private static final Logger LOG = LoggerFactory.getLogger(HousePositionsValidator.class);
    private final LocationHelper locationHelper;
    private final JdnrHelper jdnrHelper;

    @Autowired
    public HousePositionsValidator(@NonNull final LocationHelper locationHelper,
                                   @NonNull final JdnrHelper jdnrHelper) {
        super();
        this.locationHelper = locationHelper;
        this.jdnrHelper = jdnrHelper;
    }

    @Override
    protected boolean validated(@NonNull final RequestInterface request) {
        try {
            HousePositionsRequest hpRequest = (HousePositionsRequest) request;
            return (jdnrHelper.checkJdnrValid(hpRequest.getJdnr()))
                    && (locationHelper.checkLocationValid(hpRequest.getLocation()));
        } catch (Exception e) {
            LOG.error("Exception: " + e);
            return false;
        }
    }
}
