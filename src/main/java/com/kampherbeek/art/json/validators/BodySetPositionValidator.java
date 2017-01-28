package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.domain.Bodynames;
import com.kampherbeek.art.domain.FloatingLimits;
import com.kampherbeek.art.json.representation.BodySetPositionRequest;
import com.kampherbeek.art.json.representation.RequestInterface;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BodySetPositionValidator extends ValidatorParent {

    private static final Logger LOG = LoggerFactory.getLogger(BodySetPositionValidator.class);

    @Override
    protected boolean validated(@NonNull final RequestInterface request) {
        try {
            BodySetPositionRequest bspRequest = (BodySetPositionRequest) request;
            return (jdnrIsValid(bspRequest.getJdnr()) && allInternalIdsAreValid(bspRequest.getInternalIds()));
        } catch (Exception e) {
            LOG.error("Exception: " + e.getMessage());
            return false;
        }
    }

    private boolean jdnrIsValid(final double jdnr) {
        return jdnr >= FloatingLimits.JULIAN_DAY_NR.getMinValue() && jdnr <= FloatingLimits.JULIAN_DAY_NR.getMaxValue();
    }

    private boolean allInternalIdsAreValid(@NonNull final List<Integer> internalIds) {
        for (int internalId : internalIds) {
            if (!internalIdIsValid(internalId)) {
                return false;
            }
        }
        return true;
    }

    private boolean internalIdIsValid(final int internalId) {
        if (internalId >= 0) {   // -1 is reserved for Epsilon and should not be used
            for (Bodynames name : Bodynames.values()) {
                if (name.getInternalId() == internalId) {
                    return true;
                }
            }
        }
        return false;
    }
}
