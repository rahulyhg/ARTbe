package com.kampherbeek.art.json.validators.helpers;

import com.kampherbeek.art.domain.IntegerLimits;
import com.kampherbeek.art.domain.SimpleDate;
import org.mockito.Mock;
import org.springframework.stereotype.Component;

@Component
public class SimpleDateHelper {

    @Mock
    private final ValueChecker valueChecker;

    public SimpleDateHelper(ValueChecker valueChecker) {
        this.valueChecker = valueChecker;
    }

    public boolean isValid(SimpleDate simpleDate) {
        return valueChecker.checkValue(simpleDate.getYear(),IntegerLimits.YEAR)
               && valueChecker.checkValue(simpleDate.getMonth(), IntegerLimits.MONTH)
               && valueChecker.checkValue(simpleDate.getDay(), IntegerLimits.DAY);
    }



}
