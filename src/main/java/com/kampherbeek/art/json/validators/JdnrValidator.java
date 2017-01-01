package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.domain.IntegerLimits;
import com.kampherbeek.art.json.representation.JdnrRequest;
import com.kampherbeek.art.json.representation.RequestInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JdnrValidator extends ValidatorParent{

    private static final Logger LOG = LoggerFactory.getLogger(JdnrValidator.class);

    @Override
    protected boolean isValid(RequestInterface request) {
        try {
            JdnrRequest jdRequest = (JdnrRequest)request;
            return checkValue(jdRequest.getYear(), IntegerLimits.YEAR)
                    && checkValue(jdRequest.getMonth(), IntegerLimits.MONTH)
                    && checkValue(jdRequest.getDay(), IntegerLimits.DAY)
                    && checkValue(jdRequest.getHours(), IntegerLimits.HOUR)
                    && checkValue(jdRequest.getMinutes(), IntegerLimits.MINUTE)
                    && checkValue(jdRequest.getSeconds(), IntegerLimits.SECOND);
        } catch (Exception e) {
            LOG.error("Exception when validating JdnrRequest: " + e.getMessage());
            return false;
        }
    }

    private boolean checkValue(int value, IntegerLimits limits) {
        return value >= limits.getMinValue() && value <= limits.getMaxValue();
    }

}
