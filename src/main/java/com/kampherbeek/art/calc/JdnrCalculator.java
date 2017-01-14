package com.kampherbeek.art.calc;

import com.kampherbeek.art.domain.SimpleDate;
import com.kampherbeek.art.domain.SimpleTime;
import com.kampherbeek.art.json.representation.JdnrRequest;
import org.springframework.stereotype.Component;
import swisseph.SweDate;

@Component
public class JdnrCalculator {

    public double calcJd(JdnrRequest request) {
        return defineDate(request).getJulDay();
    }

    private SweDate defineDate(JdnrRequest request) {
        // TODO magic values 2 constants enum
        SimpleDate simpleDate = request.getSimpleDateTime().getSimpleDate();
        SimpleTime simpleTime = request.getSimpleDateTime().getSimpleTime();
        double ut = simpleTime.getHour() + simpleTime.getMinute() / 60.0
                + simpleTime.getSecond() / 3600.0;
        return new SweDate(simpleDate.getYear(), simpleDate.getMonth(), simpleDate.getDay(), ut,
                simpleDate.isGregorian());
    }
}
