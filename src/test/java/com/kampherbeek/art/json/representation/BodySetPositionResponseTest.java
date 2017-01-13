package com.kampherbeek.art.json.representation;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BodySetPositionResponseTest {


    private List<BodyPositionResponse> positions;
    private BodySetPositionResponse response;


    @Before
    public void setUp() throws Exception {
        positions = new ArrayList<>();
        response = new BodySetPositionResponse(positions);
    }

    @Test
    public void getPositions() throws Exception {
        assertEquals(positions, response.getPositions());
    }
}