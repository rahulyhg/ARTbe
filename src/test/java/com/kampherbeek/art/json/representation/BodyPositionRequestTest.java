package com.kampherbeek.art.json.representation;

import org.junit.Before;
import org.junit.Test;

import static com.kampherbeek.art.TestConstants.DOUBLE_MARGIN;
import static org.junit.Assert.assertEquals;

public class BodyPositionRequestTest {

    private BodyPositionRequest request;

    @Before
    public void setUp() throws Exception {
        request = new BodyPositionRequest();
    }

    @Test
    public void getSetInternalId() throws Exception {
        int internalId = 3;
        request.setInternalId(internalId);
        assertEquals(internalId, request.getInternalId());
    }

    @Test
    public void getSetJdnr() throws Exception {
        double jdnr = 1234567.89;
        request.setJdnr(jdnr);
        assertEquals(jdnr, request.getJdnr(), DOUBLE_MARGIN.getValue());
    }

    @Test
    public void getSetFlagValue() throws Exception {
        int flag = 1;
        request.setFlagValue(flag);
        assertEquals(flag, request.getFlagValue());
    }
}