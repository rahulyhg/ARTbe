package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.domain.Bodynames;
import com.kampherbeek.art.domain.FloatingLimits;
import com.kampherbeek.art.json.representation.BodyPositionRequest;
import com.kampherbeek.art.json.representation.RequestInterface;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class BodyPositionValidator extends ValidatorParent {

    private static final Logger LOG = LoggerFactory.getLogger(BodyPositionValidator.class);

    @Override
    protected boolean validated(@NonNull final RequestInterface request) {
        try {
            BodyPositionRequest bpRequest = (BodyPositionRequest) request;
            return jdnrIsValid(bpRequest.getJdnr()) && internalIdIsValid(bpRequest.getInternalId());
        } catch (Exception e) {
            LOG.error("Exception: " + e);
            return false;
        }
    }

    private boolean jdnrIsValid(final double jdnr) {
        return jdnr >= FloatingLimits.JULIAN_DAY_NR.getMinValue() && jdnr <= FloatingLimits.JULIAN_DAY_NR.getMaxValue();
    }

    private boolean internalIdIsValid(final int internalId) {
        if (internalId >= 0) {   // -1 is reserved for Epsilon and should not be used here
            for (Bodynames name : Bodynames.values()) {
                if (name.getInternalId() == internalId) {
                    return true;
                }
            }
        }
        return false;
    }
}

