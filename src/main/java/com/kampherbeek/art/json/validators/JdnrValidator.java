package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.domain.IntegerLimits;
import com.kampherbeek.art.domain.SimpleDate;
import com.kampherbeek.art.domain.SimpleTime;
import com.kampherbeek.art.json.representation.JdnrRequest;
import com.kampherbeek.art.json.representation.RequestInterface;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JdnrValidator extends ValidatorParent {

    private static final Logger LOG = LoggerFactory.getLogger(JdnrValidator.class);

    @Override
    protected boolean validated(@NonNull final RequestInterface request) {
        try {
            JdnrRequest jdRequest = (JdnrRequest) request;
            SimpleDate simpleDate = jdRequest.getSimpleDateTime().getSimpleDate();
            SimpleTime simpleTime = jdRequest.getSimpleDateTime().getSimpleTime();
            return checkDate(simpleDate) && checkTime(simpleTime);
        } catch (Exception e) {
            LOG.error("Exception when validating JdnrRequest: " + e);
            return false;
        }
    }

    private boolean checkDate(SimpleDate simpleDate) {
        return checkValue(simpleDate.getYear(), IntegerLimits.YEAR)
                && checkValue(simpleDate.getMonth(), IntegerLimits.MONTH)
                && checkValue(simpleDate.getDay(), IntegerLimits.DAY);
    }

    private boolean checkTime(SimpleTime simpleTime) {
        return checkValue(simpleTime.getHour(), IntegerLimits.HOUR)
                && checkValue(simpleTime.getMinute(), IntegerLimits.MINUTE)
                && checkValue(simpleTime.getSecond(), IntegerLimits.SECOND);
    }


    private boolean checkValue(final int value, @NonNull final IntegerLimits limits) {
        return value >= limits.getMinValue() && value <= limits.getMaxValue();
    }
}
