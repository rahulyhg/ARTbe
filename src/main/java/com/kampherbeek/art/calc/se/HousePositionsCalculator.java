package com.kampherbeek.art.calc.se;

import com.kampherbeek.art.domain.HousePositions;
import com.kampherbeek.art.domain.HouseSystems;
import com.kampherbeek.art.domain.Location;
import com.kampherbeek.art.json.validators.VersionValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import swisseph.SwissEph;

@Component
public class HousePositionsCalculator {

    private static final Logger LOG = LoggerFactory.getLogger(VersionValidator.class);
    private SwissEph swissEph;

//    /**
//     * This class is instantiated by SEFrontend, using SwissEph as a parameter, to make sure only one instance of
//     * SwissEph is instantiated. To prevent unintentional instantiations, the class is package-friendly.
//     * @param swissEph instance of SwissEph (singleton). SwissEph is a part of the Mack library.
//     */
//    HousePositionsCalculator(final SwissEph swissEph) {
//        this.swissEph = swissEph;
//    }

    public void setSwissEph(final SwissEph swissEph) {
        this.swissEph = swissEph;
    }

    HousePositions calcHouses(HouseSystems system, Location location, double jdnr, int flagValue) {
        double[] cuspPositions = new double[system.getNrOfCusps() + 1];
        double[] additionalPositions = new double[10];
        int returnCode = 0;
        try {
            returnCode = swissEph.swe_houses(jdnr, flagValue, location.getLatitude(), location.getLongitude(),
                    system.getSeId(), cuspPositions, additionalPositions);
        } catch(Exception e) {
            LOG.error("HousePositionsCalculator. Exception: " + e.getMessage());
            throw new RuntimeException(String.format("Error when calculating houses, flagValue: %1$d . Returncode: %2$d .",
                    flagValue, returnCode));
        }
        return new HousePositions(system, cuspPositions, additionalPositions);
    }
}
