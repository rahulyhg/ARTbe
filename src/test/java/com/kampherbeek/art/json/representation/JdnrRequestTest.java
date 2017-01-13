package com.kampherbeek.art.json.representation;

import com.kampherbeek.art.domain.SimpleDateTime;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class JdnrRequestTest {

    @Mock
    private SimpleDateTime simpleDateTimeMock = mock(SimpleDateTime.class);

    private JdnrRequest request;

    @Before
    public void setUp() throws Exception {
        request = new JdnrRequest();
    }

    @Test
    public void getSetSimpleDateTimeYear() throws Exception {
        request.setSimpleDateTime(simpleDateTimeMock);
        assertEquals(simpleDateTimeMock, request.getSimpleDateTime());
    }
}