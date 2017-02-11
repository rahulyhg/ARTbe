package com.kampherbeek.art.calc.se;

import com.kampherbeek.art.domain.CalculationFlags;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Creates value for flags for the SwissEphemeris.
 */
@Component
public class SeFlags2IntCreator {

    /**
     * Create the combined value for all flags by binary or'ing all values.
     * @param flags list with flags.
     * @return calculated value.
     */
    public int createFlags(List<CalculationFlags> flags) {
        int flagResult = 0;
        for (CalculationFlags flag : flags) {
            flagResult|= flag.getFlagId();
        }
        return flagResult;
    }

}
