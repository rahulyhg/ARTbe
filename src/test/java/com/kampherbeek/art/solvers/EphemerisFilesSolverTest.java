package com.kampherbeek.art.solvers;

import com.kampherbeek.art.config.Settings;
import com.kampherbeek.art.domain.EphemerisRanges;
import com.kampherbeek.art.json.representation.EphemerisFilesResponse;
import com.kampherbeek.art.json.representation.SettingsResponse;
import com.kampherbeek.art.util.EphemerisFilesChecker;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EphemerisFilesSolverTest {

    @Mock
    private EphemerisFilesChecker checkerMock = mock(EphemerisFilesChecker.class);
    @Mock
    private SettingsSolver settingsSolverMock = mock(SettingsSolver.class);
    @Mock
    private SettingsResponse settingsResponseMock = mock(SettingsResponse.class);
    @Mock
    private Settings settingsMock = mock(Settings.class);

    private final String sePath = "mySePath";
    private final EphemerisRanges range = EphemerisRanges.FULL;
    private List<String> missingFiles;

    private EphemerisFilesSolver ephFilesSolver;

    @Before
    public void setUp() throws Exception {
        missingFiles = new ArrayList<>();
        when(settingsSolverMock.solveRequest()).thenReturn(settingsResponseMock);
        when(settingsResponseMock.getSettings()).thenReturn(settingsMock);
        when(settingsMock.getSePath()).thenReturn(sePath);
        when(settingsMock.getEphemerisRange()).thenReturn(range);
        when(checkerMock.checkRange(anyObject(), anyString())).thenReturn(true);
        when(checkerMock.getMissingFiles()).thenReturn(missingFiles);
        ephFilesSolver = new EphemerisFilesSolver(settingsSolverMock, checkerMock);
    }

    @Test
    public void solveRequest() throws Exception {
        EphemerisFilesResponse result = ephFilesSolver.solveRequest();
        assertTrue(result.isFilesOk());
        assertEquals(missingFiles, result.getMissingFiles());
    }
}
