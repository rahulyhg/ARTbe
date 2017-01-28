package com.kampherbeek.art.json.validators.helpers;

import com.kampherbeek.art.domain.SimpleDateTime;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleDateTimeHelper {

    private final SimpleDateHelper dateHelper;
    private final SimpleTimeHelper timeHelper;

    @Autowired
    public SimpleDateTimeHelper(@NonNull final SimpleDateHelper dateHelper,
                                @NonNull final SimpleTimeHelper timeHelper) {
        this.dateHelper = dateHelper;
        this.timeHelper = timeHelper;
    }

    public boolean checkDateTimeValid(@NonNull final SimpleDateTime simpleDateTime) {
        return dateHelper.checkDateValid(simpleDateTime.getSimpleDate())
                && timeHelper.checkTimeValid(simpleDateTime.getSimpleTime());
    }
}
