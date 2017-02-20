package com.kampherbeek.art.solvers;

import com.kampherbeek.art.json.representation.SingleCyclesRequest;
import com.kampherbeek.art.json.representation.SingleCyclesResponse;
import com.kampherbeek.art.periods.PeriodParser;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SingleCyclesSolver {


    private final PeriodParser periodParser;

    @Autowired
    public SingleCyclesSolver(@NonNull PeriodParser periodParser) {
        this.periodParser = periodParser;
    }

    public SingleCyclesResponse solveRequest(@NonNull final SingleCyclesRequest request) {
        return new SingleCyclesResponse(periodParser.lookForOccurrences(request));
    }

}
