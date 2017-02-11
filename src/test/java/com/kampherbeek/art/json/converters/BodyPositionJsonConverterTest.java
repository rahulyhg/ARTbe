package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.domain.CalculationFlags;
import com.kampherbeek.art.domain.CalculationPreferences;
import com.kampherbeek.art.json.representation.BodyPositionRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.kampherbeek.art.TestConstants.DOUBLE_MARGIN;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BodyPositionJsonConverterTest {


    private final double jdnr = 1234567.89;
    private final int internalId = 3;
    private final int nrOfFlags = 1;

    private BodyPositionJsonConverter converter;

    @Before
    public void setUp() throws Exception {
        converter = new BodyPositionJsonConverter();

    }

    @Test
    public void jsonRequest2Java() throws Exception {
        String jsonRequest = "{\"internalId\":3,\"jdnr\":1234567.89,\"calculationPreferences\":{\"flags\":[\"SPEED\"]}}";
        BodyPositionRequest request = converter.jsonRequest2Java(jsonRequest);
        assertEquals(jdnr, request.getJdnr(), DOUBLE_MARGIN.getValue());
        assertEquals(nrOfFlags, request.getCalculationPreferences().getFlags().size());
        assertEquals(internalId, request.getInternalId());
    }

    // Convenience method to construct correct Json for request.
    @Test
    public void java2Json() throws Exception {
        BodyPositionRequest request = new BodyPositionRequest();
        List<CalculationFlags> flags = new ArrayList<>();
        flags.add(CalculationFlags.SPEED);
        CalculationPreferences preferences = new CalculationPreferences(flags);
        request.setCalculationPreferences(preferences);
        request.setJdnr(jdnr);
        request.setInternalId(internalId);
        String json = converter.java2JsonRequest(request);
        assertTrue(json.contains("internalId"));
    }

}
