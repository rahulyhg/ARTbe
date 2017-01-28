package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.domain.FloatingLimits;
import com.kampherbeek.art.json.representation.EpsilonRequest;
import com.kampherbeek.art.json.representation.RequestInterface;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EpsilonValidator extends ValidatorParent {

    private static final Logger LOG = LoggerFactory.getLogger(EpsilonValidator.class);

    @Override
    protected boolean validated(@NonNull final RequestInterface request) {
        try {
            EpsilonRequest epsRequest = (EpsilonRequest) request;
            return checkValue(epsRequest.getJdnr());
        } catch (Exception e) {
            LOG.error("Exception when validating EpsilonRequest: " + e);
            return false;
        }
    }

    private boolean checkValue(final double value) {
        return value >= FloatingLimits.JULIAN_DAY_NR.getMinValue()
                && value <= FloatingLimits.JULIAN_DAY_NR.getMaxValue();
    }
}
