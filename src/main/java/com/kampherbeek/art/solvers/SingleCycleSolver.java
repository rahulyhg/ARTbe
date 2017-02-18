package com.kampherbeek.art.solvers;

import com.kampherbeek.art.json.representation.SingleCyclesRequest;
import com.kampherbeek.art.json.representation.SingleCyclesResponse;
import com.kampherbeek.art.periods.PeriodParser;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SingleCycleSolver {


    private final PeriodParser periodParser;

    @Autowired
    public SingleCycleSolver(@NonNull PeriodParser periodParser) {
        this.periodParser = periodParser;
    }

    public SingleCyclesResponse solveRequest(@NonNull final SingleCyclesRequest request) {
//        Bodynames bodyname = Bodynames.findBodyname4InternalId(request.getInternalId());
//        int combinedFlags = seFlags2IntCreator.createFlags(request.getCalculationPreferences().getFlags());
//
//
//        List<SingleCyclesRow> foundOccurrences = periodParser.lookForOccurrences(request.getSingleCyclesMethod(),
//                request.getInternalId(), request.getStartJdnr(), request.getEndJdnr(), combinedFlags);
//
//        return new SingleCyclesResponse(foundOccurrences);
        return null;
    }

}
