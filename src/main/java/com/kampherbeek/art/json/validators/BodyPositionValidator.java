package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.domain.Bodynames;
import com.kampherbeek.art.domain.FloatingLimits;
import com.kampherbeek.art.json.representation.BodyPositionRequest;
import com.kampherbeek.art.json.representation.RequestInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BodyPositionValidator extends ValidatorParent {

    private static final Logger LOG = LoggerFactory.getLogger(BodyPositionValidator.class);

    @Override
    protected boolean isValid(RequestInterface request) {
        try {
            BodyPositionRequest bpRequest = (BodyPositionRequest) request;
            return (jdnrIsValid(bpRequest.getJdnr()) && internalIdIsValid(bpRequest.getInternalId()));
        } catch (Exception e) {
            LOG.error("Exception: " + e.getMessage());
            return false;
        }
    }

    private boolean jdnrIsValid(double jdnr) {
        return jdnr >= FloatingLimits.JULIAN_DAY_NR.getMinValue() && jdnr <= FloatingLimits.JULIAN_DAY_NR.getMaxValue();
    }

    private boolean internalIdIsValid(int internalId) {
        if (internalId < 0) {
            return false;       // added check for internalId for Epsilon, which is -1.
        }
        for (Bodynames name : Bodynames.values()) {
            if (name.getInternalId() == internalId) {
                return true;
            }
        }
        return false;
    }
}

