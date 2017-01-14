package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.EpsilonRequest;
import org.junit.Before;
import org.junit.Test;

import static com.kampherbeek.art.TestConstants.DOUBLE_MARGIN;
import static org.junit.Assert.assertEquals;

public class EpsilonJsonConverterTest {

    private EpsilonJsonConverter converter;

    @Before
    public void setUp() throws Exception {
        converter = new EpsilonJsonConverter();
    }

    @Test
    public void jsonRequest2Java() throws Exception {
        String jsonRequest = "{\"jdnr\":1234567.8}";
        EpsilonRequest request = converter.jsonRequest2Java(jsonRequest);
        assertEquals(1234567.8, request.getJdnr(), DOUBLE_MARGIN.getValue());
    }
}