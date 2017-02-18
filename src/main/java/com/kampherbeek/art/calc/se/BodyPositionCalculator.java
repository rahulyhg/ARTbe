package com.kampherbeek.art.calc.se;

import com.kampherbeek.art.domain.BasePosition;
import com.kampherbeek.art.domain.BodyPosition;
import com.kampherbeek.art.domain.Bodynames;
import lombok.NonNull;
import org.springframework.stereotype.Component;
import swisseph.SwissEph;

@Component
public class BodyPositionCalculator {


    private SwissEph swissEph;

    void setSwissEph(@NonNull final SwissEph swissEph) {
        this.swissEph = swissEph;
    }

    BodyPosition calcBody(int internalId, double jdnr, int flagValue) {
        Bodynames bodyname = Bodynames.findBodyname4InternalId(internalId);
        double[] values = new double[6];
        StringBuffer errorTxt = new StringBuffer();     // SwissEph requires StringBuffer.
        swissEph.swe_calc_ut(jdnr, bodyname.getSeId(), flagValue, values, errorTxt);
        // TODO eventueel checken op errorTxt, wordt ook gevuld als Moshier wordt gebruikt
        BasePosition coordinates = new BasePosition(values[0], values[1], values[2]);
        BasePosition speed = new BasePosition(values[3], values[4], values[5]);
        return new BodyPosition(coordinates, speed);
    }

}


