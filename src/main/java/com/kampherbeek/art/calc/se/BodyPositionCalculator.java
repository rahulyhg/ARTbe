package com.kampherbeek.art.calc.se;

import com.kampherbeek.art.domain.BasePosition;
import com.kampherbeek.art.domain.BodyPosition;
import com.kampherbeek.art.domain.Bodynames;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import swisseph.SwissEph;

@Component
public class BodyPositionCalculator {

    private static final Logger LOG = LoggerFactory.getLogger(BodyPositionCalculator.class);
    private SwissEph swissEph;

    void setSwissEph(final @NonNull SwissEph swissEph) {
        this.swissEph = swissEph;
    }

    BodyPosition calcBody(int internalId, double jdnr, int flagValue) {
        Bodynames bodyname = findBodyname4InternalId(internalId);
        double[] values = new double[6];
        StringBuffer errorTxt = new StringBuffer();
        swissEph.swe_calc_ut(jdnr, bodyname.getSeId(), flagValue, values, errorTxt);
        // TODO eventueel aanzetten, gaat ook af als Moshier wordt gebruikt.
//        if (errorTxt.toString().length() > 0) {
//            LOG.error("Error from SE when calculating body: " + errorTxt.toString());
//            throw new RuntimeException("Error from SE when calculating body.");
//        }
        BasePosition coordinates = new BasePosition(values[0], values[1], values[2]);
        BasePosition speed = new BasePosition(values[3], values[4], values[5]);
        return new BodyPosition(coordinates, speed);
    }

    private Bodynames findBodyname4InternalId(int internalId) {
        for (Bodynames bodyname : Bodynames.values()) {
            if (bodyname.getInternalId() == internalId) {
                return bodyname;
            }
        }
        LOG.error("Searching for non-existing body: " + internalId);
        throw new RuntimeException("Bodyname not found");
    }
}


