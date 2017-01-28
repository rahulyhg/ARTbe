package com.kampherbeek.art.calc.se;

import com.kampherbeek.art.domain.HousePositions;
import com.kampherbeek.art.domain.HouseSystems;
import com.kampherbeek.art.domain.Location;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import swisseph.SwissEph;

@Component
public class HousePositionsCalculator {

    private static final Logger LOG = LoggerFactory.getLogger(HousePositionsCalculator.class);
    private SwissEph swissEph;

    void setSwissEph(@NonNull final SwissEph swissEph) {
        this.swissEph = swissEph;
    }

    HousePositions calcHouses(int internalId, @NonNull Location location, double jdnr, int flagValue) {
        HouseSystems system = findSystem4InternalId(internalId);
        double[] cuspPositions = new double[system.getNrOfCusps() + 1];
        double[] additionalPositions = new double[10];
        int returnCode = 0;
        try {
            swissEph.swe_houses(jdnr, flagValue, location.getLatitude(), location.getLongitude(),
                    system.getSeId(), cuspPositions, additionalPositions);
        } catch (Exception e) {
            LOG.error("Exception: " + e);
            throw new RuntimeException(String.format("Error when calculating houses, flagValue: %1$d . Returncode: %2$d .",
                    flagValue, returnCode));
        }
        return new HousePositions(system, cuspPositions, additionalPositions);
    }

    private HouseSystems findSystem4InternalId(int internalId) {
        for (HouseSystems system : HouseSystems.values()) {
            if (system.getInternalId() == internalId) {
                return system;
            }
        }
        LOG.error("Searching for non-existing system: %d", internalId);
        throw new RuntimeException("HouseSystem not found");
    }
}
