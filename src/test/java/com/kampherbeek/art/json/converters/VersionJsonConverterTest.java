package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.VersionRequest;
import com.kampherbeek.art.json.representation.VersionResponse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VersionJsonConverterTest {

    String jsonRequest = "{\"versionType\":\"full\"}";
    String jsonResponse = "{\"versionType\":\"full\",\"versionId\":\"1.2.3\"}";
    VersionResponse versionResponse;
    VersionJsonConverter converter;

    @Before
    public void setUp() throws Exception {
        converter = new VersionJsonConverter();
        versionResponse = new VersionResponse("full", "1.2.3");
    }

    @Test
    public void json2Java() throws Exception {
        VersionRequest request = converter.jsonRequest2Java(jsonRequest);
        assertEquals("full", request.getVersionType());
    }

    @Test
    public void java2Json() throws Exception {
        assertEquals(jsonResponse, converter.java2JsonResponse(versionResponse));
    }
}