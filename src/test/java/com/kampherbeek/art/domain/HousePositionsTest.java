package com.kampherbeek.art.domain;

import org.junit.Before;
import org.junit.Test;

import static com.kampherbeek.art.TestConstants.DOUBLE_MARGIN;
import static org.junit.Assert.assertEquals;

public class HousePositionsTest {

    private final HouseSystems system = HouseSystems.ALCABITIUS;
    private final double longMC = 270.0;
    private final double longAsc = 0.0;
    private final double armc = 272.30;
    private final double vertex = 183.0;
    private final double eastPoint = 2.0;
    private double[] cusps;
    private HousePositions positions;

    @Before
    public void setUp() throws Exception {
        cusps = new double[]{0.0, longAsc, 30.0, 60.0, 90.0, 120.0, 150.0, 180.0, 210.0, 240.0, longMC, 300.0, 330.0};
        double[] additionalPositions = new double[]{longAsc, longMC, armc, vertex, eastPoint};
        positions = new HousePositions(system, cusps, additionalPositions);
    }

    @Test
    public void getMC() throws Exception {
        assertEquals(longMC, positions.getMC(), DOUBLE_MARGIN.getValue());
    }

    @Test
    public void getArmc() throws Exception {
        assertEquals(armc, positions.getArmc(), DOUBLE_MARGIN.getValue());
    }

    @Test
    public void getAscendant() throws Exception {
        assertEquals(longAsc, positions.getAscendant(), DOUBLE_MARGIN.getValue());
    }

    @Test
    public void getVertex() throws Exception {
        assertEquals(vertex, positions.getVertex(), DOUBLE_MARGIN.getValue());
    }

    @Test
    public void getEastPoint() throws Exception {
        assertEquals(eastPoint, positions.getEastPoint(), DOUBLE_MARGIN.getValue());
    }

    @Test
    public void getSystem() throws Exception {
        assertEquals(system, positions.getSystem());
    }

    @Test
    public void getCusps() throws Exception {
        assertEquals(cusps, positions.getCusps());
    }
}