package com.kampherbeek.art.periods;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PeriodCruncherTest {

    private PeriodCruncher cruncher;
    private final double margin = 0.000000001;

    @Before
    public void setUp() throws Exception {
        cruncher = new PeriodCruncher();
    }

    @Test
    public void createJdnrs() throws Exception {
        double beginJdnr = 123456.5;
        double endJdnr = 123556.5;
        double interval = 10.0;
        List<Double> result = cruncher.createJdnrs(beginJdnr, endJdnr, interval);
        assertEquals(10, result.size());
        assertEquals(123466.5, result.get(1), margin);
    }
}