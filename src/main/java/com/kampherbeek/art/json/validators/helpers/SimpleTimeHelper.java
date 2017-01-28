package com.kampherbeek.art.json.validators.helpers;

import com.kampherbeek.art.domain.IntegerLimits;
import com.kampherbeek.art.domain.SimpleTime;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class SimpleTimeHelper {

    private final ValueChecker valueChecker;

    public SimpleTimeHelper(@NonNull final ValueChecker valueChecker) {
        this.valueChecker = valueChecker;
    }

    public boolean checkTimeValid(@NonNull final SimpleTime simpleTime) {
        return valueChecker.checkValue(simpleTime.getHour(), IntegerLimits.HOUR)
                && valueChecker.checkValue(simpleTime.getMinute(), IntegerLimits.MINUTE)
                && valueChecker.checkValue(simpleTime.getSecond(), IntegerLimits.SECOND);
    }
}
