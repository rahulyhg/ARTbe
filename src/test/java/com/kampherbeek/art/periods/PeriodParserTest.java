package com.kampherbeek.art.periods;

import com.kampherbeek.art.domain.*;
import com.kampherbeek.art.json.representation.SingleCyclesRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PeriodParserTest {

    private final PeriodCruncher periodCruncherMock = mock(PeriodCruncher.class);
    private final PeriodSelector periodSelectorMock = mock(PeriodSelector.class);
    private final PeriodValueDefiner periodValueDefinerMock = mock(PeriodValueDefiner.class);
    private final SingleCyclesRequest requestMock = mock(SingleCyclesRequest.class);
    private final CalculationPreferences calculationPreferencesMock = mock(CalculationPreferences.class);

    private PeriodParser parser;

    @Before
    public void setUp() throws Exception {
        when(calculationPreferencesMock.getFlags()).thenReturn(createFlags());
        when(requestMock.getCalculationPreferences()).thenReturn(calculationPreferencesMock);
        when(requestMock.getInternalId()).thenReturn(4);
        when(requestMock.getSingleCyclesMethod()).thenReturn(SingleCyclesMethod.SPEED);
        when(requestMock.getPeriodResultFormat()).thenReturn(PeriodResultFormat.SCREEN);
        when(requestMock.getStartJdnr()).thenReturn(2000000.0);
        when(requestMock.getEndJdnr()).thenReturn(2000100.0);
        when(requestMock.getLocale()).thenReturn("nl");
        parser = new PeriodParser(periodCruncherMock, periodSelectorMock, periodValueDefinerMock);
    }

    @Test
    public void lookForOccurrences() throws Exception {
        try {
            parser.lookForOccurrences(requestMock);
            assertTrue("No exception occurred", true);
        } catch (Exception e) {
            fail("An unexpected excewption occurred : " + e.getMessage());
        }
    }

    private List<CalculationFlags> createFlags() {
        List<CalculationFlags> flags = new ArrayList<>();
        flags.add(CalculationFlags.SWIEPH);
        flags.add(CalculationFlags.SPEED);
        return flags;
    }
}