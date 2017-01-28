package com.kampherbeek.art.calc;

import com.kampherbeek.art.domain.SimpleDate;
import com.kampherbeek.art.domain.SimpleTime;
import com.kampherbeek.art.domain.TimeConstants;
import com.kampherbeek.art.json.representation.JdnrRequest;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import swisseph.SweDate;

@Component
public class JdnrCalculator {

    public double calcJd(JdnrRequest request) {
        return defineDate(request).getJulDay();
    }

    private SweDate defineDate(@NonNull JdnrRequest request) {
        SimpleDate simpleDate = request.getSimpleDateTime().getSimpleDate();
        SimpleTime simpleTime = request.getSimpleDateTime().getSimpleTime();
        double ut = simpleTime.getHour() + simpleTime.getMinute() / (double) TimeConstants.MINUTES_PER_HOUR.getValue()
                + simpleTime.getSecond() / (double) TimeConstants.SECONDS_PER_HOUR.getValue();
        return new SweDate(simpleDate.getYear(), simpleDate.getMonth(), simpleDate.getDay(), ut,
                simpleDate.isGregorian());
    }
}
