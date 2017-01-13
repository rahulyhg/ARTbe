package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.BodyPositionRequest;
import org.junit.Before;
import org.junit.Test;

import static com.kampherbeek.art.TestConstants.DOUBLE_MARGIN;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BodyPositionJsonConverterTest {

    private final String jsonRequest = "{\"internalId\":3,\"jdnr\":1234567.89,\"flagValue\":1}";
    private final int flagValue = 1;
    private final double jdnr = 1234567.89;
    private final int internalId = 3;

    private BodyPositionJsonConverter converter;

    @Before
    public void setUp() throws Exception {

        converter = new BodyPositionJsonConverter();
    }

    @Test
    public void jsonRequest2Java() throws Exception {
        BodyPositionRequest request = converter.jsonRequest2Java(jsonRequest);
        assertEquals(jdnr, request.getJdnr(), DOUBLE_MARGIN.getValue());
        assertEquals(flagValue, request.getFlagValue());
        assertEquals(internalId, request.getInternalId());
    }


    // Convenience method to construct correct Json for request.
    @Test
    public void java2Json() throws Exception {
        BodyPositionRequest request = new BodyPositionRequest();
        request.setFlagValue(flagValue);
        request.setJdnr(jdnr);
        request.setInternalId(internalId);
        String json = converter.java2JsonRequest(request);
        assertTrue(json.contains("internalId"));
    }

}
