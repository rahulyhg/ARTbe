package com.kampherbeek.art.calc;

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
        double ut = request.getHours() / 24.0 + request.getMinutes() / 1440.0 + request.getSeconds() / 86400.0;
        return new SweDate(request.getYear(), request.getMonth(), request.getDay(), ut, request.isGregorian());
    }

}
