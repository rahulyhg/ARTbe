package com.kampherbeek.art.json.representation;

import com.kampherbeek.art.domain.SingleCyclesRow;
import lombok.Getter;
import lombok.NonNull;

import java.util.List;

public class SingleCyclesResponse implements ResponseInterface {

    @Getter
    private final List<SingleCyclesRow> allRows;

    public SingleCyclesResponse(@NonNull List<SingleCyclesRow> allRows) {
        this.allRows = allRows;
    }

}
