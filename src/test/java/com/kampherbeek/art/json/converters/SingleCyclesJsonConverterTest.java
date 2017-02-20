package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.domain.CalculationFlags;
import com.kampherbeek.art.domain.CalculationPreferences;
import com.kampherbeek.art.domain.PeriodResultFormat;
import com.kampherbeek.art.domain.SingleCyclesMethod;
import com.kampherbeek.art.json.representation.SingleCyclesRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SingleCyclesJsonConverterTest {

    private final double jdnrStart = 1234567.89;
    private final double jdnrEnd = 1234867.89;
    private final int internalId = 3;
    private final double margin = 0.000000001;

    private SingleCyclesJsonConverter converter;

    @Before
    public void setUp() throws Exception {
        converter = new SingleCyclesJsonConverter();
    }

    @Test
    public void jsonRequest2Java() throws Exception {
        String jsonRequest = "{\"internalId\":3,\"startJdnr\":1234567.89,\"endJdnr\":1234867.89," +
                "\"calculationPreferences\":{\"flags\":[\"SWIEPH\",\"SPEED\"]}," +
                "\"periodResultFormat\":\"JSON\",\"singleCyclesMethod\":\"SPEED\"}";
        SingleCyclesRequest request = converter.jsonRequest2Java(jsonRequest);
        assertEquals(jdnrStart, request.getStartJdnr(), margin);
        assertEquals(jdnrEnd, request.getEndJdnr(), margin);
    }

    // Convenience method to construct correct Json for request.
    @Test
    public void java2Json() throws Exception {
        SingleCyclesRequest request = new SingleCyclesRequest();
        List<CalculationFlags> flags = new ArrayList<>();
        flags.add(CalculationFlags.SWIEPH);
        flags.add(CalculationFlags.SPEED);
        CalculationPreferences preferences = new CalculationPreferences(flags);
        request.setCalculationPreferences(preferences);
        request.setEndJdnr(jdnrEnd);
        request.setStartJdnr(jdnrStart);
        request.setInternalId(internalId);
        request.setPeriodResultFormat(PeriodResultFormat.JSON);
        request.setSingleCyclesMethod(SingleCyclesMethod.SPEED);
        request.setLocale("en");
        String json = converter.java2JsonRequest(request);
        System.out.println(json);
        assertTrue(json.contains("internalId"));
    }



}

