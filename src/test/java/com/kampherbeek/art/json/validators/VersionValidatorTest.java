package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.json.representation.VersionRequest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VersionValidatorTest {

    private final String correctType = "full";
    private final String wrongType = "wrong";

    @Mock
    private VersionRequest requestMock = mock(VersionRequest.class);
    private VersionValidator validator;

    @Before
    public void setUp() throws Exception {
        validator = new VersionValidator();
    }

    @Test
    public void isValid() throws Exception {
        when(requestMock.getVersionType()).thenReturn(correctType);
        assertTrue(validator.isValid(requestMock));
    }

    @Test
    public void isValidWrongValue() throws Exception {
        when(requestMock.getVersionType()).thenReturn(wrongType);
        assertFalse(validator.isValid(requestMock));
    }

}