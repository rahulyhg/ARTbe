package com.kampherbeek.art.util;

import com.kampherbeek.art.domain.EphemerisRanges;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EphemerisFilesCheckerTest {

    @Mock
    private PropertiesReader propertiesReaderMock = mock(PropertiesReader.class);
    private final String ephLocation = "se/";
    private final String files2CheckCurrent = "sefstars.txt,seorbel.txt,sepl_12.se1,semo_12.se1,seas_12.se1";
    private final String files2CheckExpanded = "seplm12.se1,semom12.se1,seasm12.se1,seplm06.se1,semom06.se1," +
            "seasm06.se1,sepl_00.se1,semo_00.se1,seas_00.se1,sepl_06.se1,semo_06.se1,seas_06.se1";
    private final String files2CheckFull = "seplm132.se1,semom132.se1,seplm126.se1,semom126.se1,seplm120.se1," +
            "semom120.se1,seplm114.se1,semom114.se1,seplm108.se1,semom108.se1,seplm102.se1,semom102.se1,seplm96.se1," +
            "semom96.se1,seplm90.se1,semom90.se1,seplm84.se1,semom84.se1,seplm78.se1,semom78.se1,seplm72.se1," +
            "semom72.se1,seplm66.se1,semom66.se1,seplm60.se1,semom60.se1,seplm54.se1,semom54.se1,seasm54.se1," +
            "seplm48.se1,semom48.se1,seasm48.se1,seplm42.se1,semom42.se1,seasm42.se1,seplm36.se1,semom36.se1," +
            "seasm36.se1,seplm30.se1,semom30.se1,seasm30.se1,seplm24.se1,semom24.se1,seasm24.se1,seplm18.se1," +
            "semom18.se1,seasm18.se1,sepl_24.se1,semo_24.se1,seas_24.se1,sepl_30.se1,semo_30.se1,seas_30.se1," +
            "sepl_36.se1,semo_36.se1,seas_36.se1,sepl_42.se1,semo_42.se1,seas_42.se1,sepl_48.se1,semo_48.se1," +
            "seas_48.se1,sepl_54.se1,semo_54.se1,sepl_60.se1,semo_60.se1,sepl_66.se1,semo_66.se1,sepl_72.se1," +
            "semo_72.se1,sepl_78.se1,semo_78.se1,sepl_84.se1,semo_84.se1,sepl_90.se1,semo_90.se1,sepl_96.se1," +
            "semo_96.se1,sepl_102.se1,semo_102.se1,sepl_108.se1,semo_108.se1,sepl_114.se1,semo_114.se1,sepl_120.se1," +
            "semo_120.se1,sepl_126.se1,semo_126.se1,sepl_132.se1,semo_132.se1,sepl_138.se1,semo_138.se1,sepl_144.se1," +
            "semo_144.se1,sepl_150.se1,semo_150.se1,sepl_156.se1,semo_156.se1,sepl_162.se1,semo_162.se1";
    private EphemerisFilesChecker ephemerisFilesChecker;


    @Before
    public void setUp() throws Exception {
        when(propertiesReaderMock.readValueForProperty("ephemeris.location")).thenReturn(ephLocation);
        when(propertiesReaderMock.readValueForProperty("ephemeris.files.current")).thenReturn(files2CheckCurrent);
        when(propertiesReaderMock.readValueForProperty("ephemeris.files.expanded")).thenReturn(files2CheckExpanded);
        when(propertiesReaderMock.readValueForProperty("ephemeris.files.full")).thenReturn(files2CheckFull);
        ephemerisFilesChecker = new EphemerisFilesChecker(propertiesReaderMock);
    }


    @Test
    public void checkRangeCurrent() throws Exception {
        assertTrue(ephemerisFilesChecker.checkRange(EphemerisRanges.CURRENT, ephLocation));
    }

    @Test
    public void checkRangeExpanded() throws Exception {
        assertTrue(ephemerisFilesChecker.checkRange(EphemerisRanges.EXPANDED, ephLocation));
    }

    @Test
    public void checkRangeFull() throws Exception {
        assertTrue(ephemerisFilesChecker.checkRange(EphemerisRanges.FULL, ephLocation));
    }
    @Test
    public void checkRangeError() throws Exception {
        String files2CheckWithError = "sefstars.txt,seorbel.txt,doesnotexist.xxx,sepl_12.se1,semo_12.se1,seas_12.se1";
        when(propertiesReaderMock.readValueForProperty("ephemeris.files.current")).
                thenReturn(files2CheckWithError);
        assertFalse(ephemerisFilesChecker.checkRange(EphemerisRanges.CURRENT, ephLocation));
    }


    @Test
    public void getMissingFiles() throws Exception {
        String files2CheckWithError = "sefstars.txt,seorbel.txt,doesnotexist.xxx,sepl_12.se1,semo_12.se1,seas_12.se1";
        when(propertiesReaderMock.readValueForProperty("ephemeris.files.current")).
                thenReturn(files2CheckWithError);
        ephemerisFilesChecker.checkRange(EphemerisRanges.CURRENT, ephLocation);
        assertEquals("doesnotexist.xxx", ephemerisFilesChecker.getMissingFiles().get(0));
    }
}