package com.kampherbeek.art.periods;

import com.kampherbeek.art.domain.SingleCyclesRow;
import com.kampherbeek.art.json.representation.SingleCyclesRequest;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PeriodParser {

    private final PeriodCruncher periodCruncher;
    private final PeriodSelector periodSelector;
    private final PeriodValueDefiner periodValueDefiner;

    private final static double stepSize = 1.0;
    private final static double minStepSize = 0.000005; // about 0.4 second

    public PeriodParser(@NonNull PeriodCruncher periodCruncher,
                        @NonNull PeriodSelector periodSelector,
                        @NonNull PeriodValueDefiner periodValueDefiner) {
        this.periodCruncher = periodCruncher;
        this.periodSelector = periodSelector;
        this.periodValueDefiner = periodValueDefiner;
    }

    public List<SingleCyclesRow> lookForOccurrences(@NonNull SingleCyclesRequest request) {
        return parseIt(request);
    }


    private List<SingleCyclesRow> parseIt(@NonNull SingleCyclesRequest request) {

        double jdnrStart = request.getStartJdnr();
        double jdnrEnd = request.getEndJdnr();
        List<Double> allJdnrs = periodCruncher.createJdnrs(jdnrStart, jdnrEnd, stepSize);
        List<Double[]> foundValues = periodValueDefiner.defineValues(allJdnrs, request);
        return periodSelector.findMatches(foundValues, request.getLocale());
    }

}
