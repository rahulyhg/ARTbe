package com.kampherbeek.art.json.representation;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VersionRequestTest {

    private final String versionType = "Short";
    private VersionRequest request;

    @Before
    public void setUp() throws Exception {
        request = new VersionRequest();
        request.setVersionType(versionType);
    }

    @Test
    public void getVersionType() throws Exception {
        assertEquals(versionType, request.getVersionType());
    }
}