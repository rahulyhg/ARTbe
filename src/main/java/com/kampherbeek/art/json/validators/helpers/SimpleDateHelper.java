package com.kampherbeek.art.json.validators.helpers;

import com.kampherbeek.art.domain.IntegerLimits;
import com.kampherbeek.art.domain.SimpleDate;
import lombok.NonNull;
import org.springframework.stereotype.Component;

@Component
public class SimpleDateHelper {

    private final ValueChecker valueChecker;

    public SimpleDateHelper(@NonNull final ValueChecker valueChecker) {
        this.valueChecker = valueChecker;
    }

    public boolean checkDateValid(@NonNull final SimpleDate simpleDate) {
        return valueChecker.checkValue(simpleDate.getYear(), IntegerLimits.YEAR)
                && valueChecker.checkValue(simpleDate.getMonth(), IntegerLimits.MONTH)
                && valueChecker.checkValue(simpleDate.getDay(), IntegerLimits.DAY);
    }
}
