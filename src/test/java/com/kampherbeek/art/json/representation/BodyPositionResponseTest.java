package com.kampherbeek.art.json.representation;

import com.kampherbeek.art.domain.BodyPosition;
import com.kampherbeek.art.domain.Bodynames;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class BodyPositionResponseTest {

    private final Bodynames bodyname = Bodynames.NEPTUNE;
    @Mock
    private BodyPosition positionMock = mock(BodyPosition.class);
    private BodyPositionResponse response;

    @Before
    public void setUp() throws Exception {
        response = new BodyPositionResponse(bodyname, positionMock);
    }

    @Test
    public void getPosition() throws Exception {
        assertEquals(positionMock, response.getPosition());
    }

    @Test
    public void getBodyname() throws Exception {
        assertEquals(bodyname, response.getBodyname());
    }
}