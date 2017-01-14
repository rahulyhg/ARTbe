package com.kampherbeek.art.json.representation;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.kampherbeek.art.TestConstants.DOUBLE_MARGIN;
import static org.junit.Assert.assertEquals;

public class BodySetPositionRequestTest {

    private List<Integer> internalIds;
    private BodySetPositionRequest request;

    @Before
    public void setUp() throws Exception {
        internalIds = new ArrayList<>();
        request = new BodySetPositionRequest();
    }

    @Test
    public void getSetJdnr() throws Exception {
        double jdnr = 1234567.89;
        request.setJdnr(jdnr);
        assertEquals(jdnr, request.getJdnr(), DOUBLE_MARGIN.getValue());
    }

    @Test
    public void getSetFlagValue() throws Exception {
        int flagValue = 1;
        request.setFlagValue(flagValue);
        assertEquals(flagValue, request.getFlagValue());
    }

    @Test
    public void getSetInternalIds() throws Exception {
        request.setInternalIds(internalIds);
        assertEquals(internalIds, request.getInternalIds());
    }
}