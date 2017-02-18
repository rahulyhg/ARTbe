package com.kampherbeek.art.periods;

import com.kampherbeek.art.domain.SpeedResults;
import org.springframework.stereotype.Component;

/**
 * Finds the moments retrogradation or direct movement starts and also the moments of maximum and minimum speed.
 */
@Component
public class SpeedPeriodComparator implements PeriodComparator {

    /**
     * Compares positions regarding speed.
     * @param positions calculated values, at 0 previous value, at 1 current value, at 2 next value.
     * @return SpeedResults.NONE if no specific condition was found, otherwise a value from SpeedResults that indicates
     * the condition.
     */
    @Override
    public SpeedResults defineResults(double[] positions) {
        return performCheck(positions);
    }

    private SpeedResults performCheck(double[] positions) {
        if (positions[0] < positions[1] && positions[1] > positions[2]) {
            return SpeedResults.MAXIMUM;
        }
        if (positions[0] > positions[1] && positions[1] < positions[2]) {
            return SpeedResults.MINIMUM;
        }
        if (positions[0] > 0.0 && positions[1] < 0.0) {
            return SpeedResults.RETRO_START;
        }
        if (positions[0] < 0.0 && positions[1] > 0.0) {
            return SpeedResults.DIRECT_START;
        }
        return SpeedResults.NONE;
    }
}
