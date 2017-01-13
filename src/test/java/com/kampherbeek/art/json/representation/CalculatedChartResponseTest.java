package com.kampherbeek.art.json.representation;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class CalculatedChartResponseTest {

    @Mock
    private BodySetPositionResponse bodiesMock = mock(BodySetPositionResponse.class);
    @Mock
    private HousePositionsResponse housesMock = mock(HousePositionsResponse.class);
    private CalculatedChartResponse response;

    @Before
    public void setUp() throws Exception {
        response = new CalculatedChartResponse(bodiesMock, housesMock);
    }

    @Test
    public void getBodySetPositionResponse() throws Exception {
        assertEquals(bodiesMock, response.getBodySetPositionResponse());
    }

    @Test
    public void getHousePositionsResponse() throws Exception {
        assertEquals(housesMock, response.getHousePositionsResponse());
    }
}