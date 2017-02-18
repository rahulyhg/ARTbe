package com.kampherbeek.art.periods;

import com.kampherbeek.art.domain.SpeedResults;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpeedPeriodComparatorTest {

    private PeriodComparator comparator;
    private double[] positions;

    @Before
    public void setUp() throws Exception {
        comparator = new SpeedPeriodComparator();
        positions = new double[3];
    }

    @Test
    public void defineResultsNone() throws Exception {
        positions[0] = 2.0;
        positions[1] = 3.0;
        positions[2] = 4.0;
        assertEquals(SpeedResults.NONE, comparator.defineResults(positions));
    }

    @Test
    public void defineResultsNoneWhileRetro() throws Exception {
        positions[0] = -2.0;
        positions[1] = -3.0;
        positions[2] = -4.0;
        assertEquals(SpeedResults.NONE, comparator.defineResults(positions));
    }


    @Test
    public void defineResultsMaximum() throws Exception {
        positions[0] = 2.0;
        positions[1] = 3.0;
        positions[2] = 2.5;
        assertEquals(SpeedResults.MAXIMUM, comparator.defineResults(positions));
    }

    @Test
    public void defineResultsMinimum() throws Exception {
        positions[0] = 4.0;
        positions[1] = 3.0;
        positions[2] = 3.5;
        assertEquals(SpeedResults.MINIMUM, comparator.defineResults(positions));
    }

    @Test
    public void defineResultsRetrograde() throws Exception {
        positions[0] = 0.5;
        positions[1] = -0.1;
        positions[2] = -2.0;
        assertEquals(SpeedResults.RETRO_START, comparator.defineResults(positions));
    }

    @Test
    public void defineResultsDirect() throws Exception {
        positions[0] = -0.5;
        positions[1] = 0.1;
        positions[2] = 2.0;
        assertEquals(SpeedResults.DIRECT_START, comparator.defineResults(positions));
    }

}