package com.kampherbeek.art.json.representation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VersionResponseTest {

    private final String type = "Full";
    private final String id = "1.2.3";
    private VersionResponse versionResponse;

    @Before
    public void setUp() throws Exception {
        versionResponse = new VersionResponse(type, id);
    }

    @Test
    public void getVersionType() throws Exception {
        assertEquals(id, versionResponse.getVersionId());
    }

    @Test
    public void getVersionId() throws Exception {
        assertEquals(type, versionResponse.getVersionType());
    }
}