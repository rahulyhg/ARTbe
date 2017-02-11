package com.kampherbeek.art.solvers;

import com.kampherbeek.art.domain.EphemerisRanges;
import com.kampherbeek.art.json.representation.SettingsResponse;
import com.kampherbeek.art.util.JsonReader;
import com.kampherbeek.art.util.PropertiesReader;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SettingsSolverTest {

    @Mock
    private JsonReader jsonReaderMock = mock(JsonReader.class);
    @Mock
    private PropertiesReader propertiesReaderMock = mock(PropertiesReader.class);
    @Mock
    private JSONObject objectMock = mock(JSONObject.class);

    private final String settingsPath = "mySettingsPath";
    private final String sePath = "mySePath";
    private final String rangeText = "FULL";
    private final EphemerisRanges ephRange = EphemerisRanges.FULL;

    private SettingsSolver solver;

    @Before
    public void setUp() throws Exception {
        when(propertiesReaderMock.readValueForProperty(anyString())).thenReturn(settingsPath);
        when(jsonReaderMock.readObjectFromFile(anyObject())).thenReturn(objectMock);
        when(objectMock.get("sePath")).thenReturn(sePath);
        when(objectMock.get("ephemerisRange")).thenReturn(rangeText);
        solver = new SettingsSolver(jsonReaderMock, propertiesReaderMock);
    }

    @Test
    public void solveRequest() throws Exception {
        SettingsResponse response = solver.solveRequest();
        assertEquals(response.getSettings().getSePath(), sePath);
        assertEquals(response.getSettings().getEphemerisRange(), ephRange);
    }
}

