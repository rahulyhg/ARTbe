package com.kampherbeek.art.periods;

import com.kampherbeek.art.domain.SingleCyclesRow;
import com.kampherbeek.art.domain.SpeedResults;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Selector for dates and values that adher to a specific condition.
 */
@Component
public class PeriodSelector {

    private final SpeedPeriodComparator comparator;


    @Autowired
    public PeriodSelector(@NonNull SpeedPeriodComparator comparator) {
        this.comparator = comparator;

    }

    public List<SingleCyclesRow> findMatches(List<Double[]> valuesIn, String localeTxt) {
        ResourceBundle bundle = ResourceBundle.getBundle("messages/messages", new Locale(localeTxt));
        List<Double[]> values2Check = valuesIn;
        List<SingleCyclesRow> allMatches = new ArrayList<>();
        double[] positions = new double[3];
        int counter = 0;
        SpeedResults result;
        for (Double[] jdnrValue : values2Check) {
            if (counter > 3) {
                positions[0] = values2Check.get(counter - 3)[1];
                positions[1] = values2Check.get(counter - 2)[1];
                positions[2] = jdnrValue[1];
                result = comparator.defineResults(positions);
                if (result != SpeedResults.NONE) {
                    SingleCyclesRow row = new SingleCyclesRow();
                    row.setDateTimeTxt("date and time");                     // TODO convert jdnr to datetime
                    row.setJdnr(positions[2]);
                    row.setPosition(jdnrValue[1]);
                    row.setDescription(bundle.getString(result.getRbIdDescription()));
                    allMatches.add(row);
                }
            }
            counter++;
        }
        return allMatches;
    }
}
