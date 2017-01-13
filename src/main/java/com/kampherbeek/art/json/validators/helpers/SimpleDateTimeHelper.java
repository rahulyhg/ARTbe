package com.kampherbeek.art.json.validators.helpers;

import com.kampherbeek.art.domain.SimpleDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleDateTimeHelper {

    private final SimpleDateHelper dateHelper;
    private final SimpleTimeHelper timeHelper;

    @Autowired
    public SimpleDateTimeHelper(SimpleDateHelper dateHelper, SimpleTimeHelper timeHelper) {
        this.dateHelper = dateHelper;
        this.timeHelper = timeHelper;
    }

    public boolean isValid(SimpleDateTime simpleDateTime) {
        return dateHelper.isValid(simpleDateTime.getSimpleDate())
                && timeHelper.isValid(simpleDateTime.getSimpleTime());
    }

}
