package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.json.representation.RequestInterface;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

public class NoParamValidatorTest {

    @Mock
    private RequestInterface requestMock = mock(RequestInterface.class);
    private NoParamValidator validator;

    @Before
    public void setUp() throws Exception {
        validator = new NoParamValidator();
    }

    @Test
    public void validated() throws Exception {
        assertTrue(validator.validated(requestMock));
    }
}