package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.domain.*;
import com.kampherbeek.art.json.representation.CalculatedChartRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static com.kampherbeek.art.TestConstants.DOUBLE_MARGIN;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculatedChartJsonConverterTest {

    @Mock
    private Location locationMock = mock(Location.class);
    @Mock
    private SimpleDate dateMock = mock(SimpleDate.class);
    @Mock
    private SimpleTime timeMock = mock(SimpleTime.class);
    @Mock
    private SimpleDateTime dateTimeMock = mock(SimpleDateTime.class);

    private List<Integer> bodyIds;
    private final int houseSystemId = HouseSystems.ALCABITIUS.getInternalId();
    private final String jsonRequest = "{\"simpleDateTime\":{\"simpleDate\":{\"year\":2002,\"month\":3,\"day\":15,\"gregorian\":true},\"simpleTime\":{\"hour\":13,\"minute\":54,\"second\":43}},\"location\":{\"longitude\":18.17,\"latitude\":55.44},\"flagValue\":258,\"houseSystemId\":12,\"bodyIds\":[0,1]}\n";
    private final int flagValue = 258;
    private final double latitude = 55.44;
    private final double longitude = 18.17;
    private final boolean isGregorian = true;
    private final int day = 15;
    private final int month = 3;
    private final int year = 2002;
    private final int hour = 13;
    private final int minute = 54;
    private final int second = 43;
    private CalculatedChartJsonConverter converter;

    @Before
    public void setUp() throws Exception {
        when(locationMock.getLatitude()).thenReturn(latitude);
        when(locationMock.getLongitude()).thenReturn(longitude);
        when(dateMock.getDay()).thenReturn(day);
        when(dateMock.getMonth()).thenReturn(month);
        when(dateMock.getYear()).thenReturn(year);
        when(dateMock.isGregorian()).thenReturn(isGregorian);
        when(timeMock.getHour()).thenReturn(hour);
        when(timeMock.getMinute()).thenReturn(minute);
        when(timeMock.getSecond()).thenReturn(second);
        when(dateTimeMock.getSimpleDate()).thenReturn(dateMock);
        when(dateTimeMock.getSimpleTime()).thenReturn(timeMock);
        bodyIds = createBodyIds();
        converter = new CalculatedChartJsonConverter();
    }

    @Test
    public void jsonRequest2Java() throws Exception {
        CalculatedChartRequest request = converter.jsonRequest2Java(jsonRequest);
        assertEquals(day, request.getSimpleDateTime().getSimpleDate().getDay());
        assertEquals(latitude, request.getLocation().getLatitude(), DOUBLE_MARGIN.getValue());
        assertEquals(flagValue, request.getFlagValue());
        assertEquals(bodyIds.get(0), request.getBodyIds().get(0));
        assertEquals(houseSystemId, request.getHouseSystemId());
    }


    // Convenience method to construct correct Json for request.
    @Test
    public void java2Json() throws Exception {
        CalculatedChartRequest request = new CalculatedChartRequest();
        Location location = new Location(longitude, latitude);
        request.setLocation(location);
        SimpleDate simpleDate = new SimpleDate(year, month, day, isGregorian);
        SimpleTime simpleTime = new SimpleTime(hour, minute, second);
        SimpleDateTime simpleDateTime = new SimpleDateTime(simpleDate, simpleTime);
        request.setSimpleDateTime(simpleDateTime);
        request.setHouseSystemId(HouseSystems.ALCABITIUS.getInternalId());
        request.setBodyIds(createBodyIds());
        request.setFlagValue(flagValue);
        String json = converter.java2JsonRequest(request);
        System.out.println(json);
        assertTrue(json.contains("simpleDateTime"));
    }

    private List<Integer> createBodyIds() {
        List<Integer> bodyIds = new ArrayList<>();
        bodyIds.add(0);
        bodyIds.add(1);
        return bodyIds;
    }
}
