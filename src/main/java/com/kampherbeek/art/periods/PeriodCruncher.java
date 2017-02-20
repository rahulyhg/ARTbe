package com.kampherbeek.art.periods;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Divides a period into a range of julian day numbers.
 */
@Component
public class PeriodCruncher {

    /**
     * Creates list of julian day numbers
     * @param beginJdnr First jdnr of rage.
     * @param endJdnr Last jdnr of range (inclusive);
     * @param interval interval between successive jdnrs.
     * @return If endJdnr > beginJdnr + interval: List with jdnrs. Else: empty list.
     */
    public List<Double> createJdnrs(final double beginJdnr, final double endJdnr, final double interval) {
        final double lastJdnrWithMargin = endJdnr - interval * 0.1;
        List<Double> periodList = new ArrayList<>();
        double currentJdnr = beginJdnr;
        while (currentJdnr < lastJdnrWithMargin) {
            periodList.add(currentJdnr);
            currentJdnr+= interval;
        }
        return periodList;
    }




}
