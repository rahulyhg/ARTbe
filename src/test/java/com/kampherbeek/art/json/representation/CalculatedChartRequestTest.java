package com.kampherbeek.art.json.representation;

import com.kampherbeek.art.domain.Location;
import com.kampherbeek.art.domain.SimpleDateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class CalculatedChartRequestTest {

    @Mock
    private SimpleDateTime dateTimeMock = mock(SimpleDateTime.class);
    @Mock
    private Location locationMock = mock(Location.class);
    private final int flagValue = 258;
    private final int houseSystemId = 7;
    private List<Integer> bodyIds;

    private CalculatedChartRequest request;

    @Before
    public void setUp() throws Exception {
        bodyIds = createBodyIds();
        double[] bodyIdsArray = {0, 1, 2};
        request = new CalculatedChartRequest();
    }

    @Test
    public void setGetSimpleDateTime() throws Exception {
        request.setSimpleDateTime(dateTimeMock);
        assertEquals(dateTimeMock, request.getSimpleDateTime());
    }

    @Test
    public void setGetLocation() throws Exception {
        request.setLocation(locationMock);
        assertEquals(locationMock, request.getLocation());
    }

    @Test
    public void setGetFlagValue() throws Exception {
        request.setFlagValue(flagValue);
        assertEquals(flagValue, request.getFlagValue());
    }

    @Test
    public void setGetHouseSystemId() throws Exception {
        request.setHouseSystemId(houseSystemId);
        assertEquals(houseSystemId, request.getHouseSystemId());
    }

    @Test
    public void setGetBodyIds() throws Exception {
        request.setBodyIds(bodyIds);
        assertEquals(bodyIds, request.getBodyIds());
    }

    private List<Integer> createBodyIds() {
        List<Integer> bodyIds = new ArrayList<>();
        bodyIds.add(0);
        bodyIds.add(1);
        bodyIds.add(2);
        return bodyIds;
    }
}