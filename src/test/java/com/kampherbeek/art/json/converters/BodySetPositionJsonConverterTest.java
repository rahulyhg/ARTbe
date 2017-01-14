package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.BodySetPositionRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.kampherbeek.art.TestConstants.DOUBLE_MARGIN;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BodySetPositionJsonConverterTest {

    private final int flagValue = 1;
    private final double jdnr = 1234567.89;
    private List<Integer> internalIds;
    private BodySetPositionJsonConverter converter;

    @Before
    public void setUp() throws Exception {
        internalIds = createInternalIds();
        converter = new BodySetPositionJsonConverter();
    }

    @Test
    public void jsonRequest2Java() throws Exception {
        String jsonRequest = "{\"jdnr\":1234567.89,\"flagValue\":1,\"internalIds\":[0,1,2,3]}";
        BodySetPositionRequest request = converter.jsonRequest2Java(jsonRequest);
        assertEquals(jdnr, request.getJdnr(), DOUBLE_MARGIN.getValue());
        assertEquals(flagValue, request.getFlagValue());
        assertEquals(internalIds, request.getInternalIds());
    }

    // Convenience method to construct correct Json for request.
    @Test
    public void java2Json() throws Exception {
        BodySetPositionRequest request = new BodySetPositionRequest();
        request.setFlagValue(flagValue);
        request.setJdnr(jdnr);
        request.setInternalIds(internalIds);
        String json = converter.java2JsonRequest(request);
        assertTrue(json.contains("internalIds"));
    }

    private List<Integer> createInternalIds() {
        List<Integer> ids = new ArrayList<>();
        for (int i = 0; i <= 3; i++) {
            ids.add(i);
        }
        return ids;
    }
}
