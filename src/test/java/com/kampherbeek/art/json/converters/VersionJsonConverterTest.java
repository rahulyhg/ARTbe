package com.kampherbeek.art.json.converters;

import com.kampherbeek.art.json.representation.VersionRequest;
import com.kampherbeek.art.json.representation.VersionResponse;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VersionJsonConverterTest {

    private final String jsonRequest = "{\"versionType\":\"full\"}";
    private VersionResponse versionResponse;
    private VersionJsonConverter converter;

    @Before
    public void setUp() throws Exception {
        converter = new VersionJsonConverter();
        versionResponse = new VersionResponse("full", "1.2.3");
    }

    @Test
    public void json2JavaRequest() throws Exception {
        VersionRequest request = converter.jsonRequest2Java(jsonRequest);
        assertEquals("full", request.getVersionType());
    }

    @Test
    public void java2JsonResponse() throws Exception {
        String jsonResponse = "{\"versionType\":\"full\",\"versionId\":\"1.2.3\"}";
        assertEquals(jsonResponse, converter.java2JsonResponse(versionResponse));
    }

    @Test
    public void java2JsonRequest() throws Exception {
        VersionRequest request = new VersionRequest();
        request.setVersionType("full");
        assertEquals(jsonRequest, converter.java2JsonRequest(request));
    }
}