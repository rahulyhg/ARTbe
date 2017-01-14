package com.kampherbeek.art.json.representation;

import org.junit.Before;
import org.junit.Test;

import static com.kampherbeek.art.TestConstants.DOUBLE_MARGIN;
import static org.junit.Assert.assertEquals;

public class EpsilonResponseTest {

    private EpsilonResponse response;

    @Before
    public void setUp() throws Exception {
        response = new EpsilonResponse();
    }

    @Test
    public void getSetEpsilon() throws Exception {
        double epsilon = 23.447;
        response.setEpsilon(epsilon);
        assertEquals(epsilon, response.getEpsilon(), DOUBLE_MARGIN.getValue());
    }
}