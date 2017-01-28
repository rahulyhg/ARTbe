package com.kampherbeek.art.json.representation;

import com.kampherbeek.art.domain.Location;
import com.kampherbeek.art.domain.SimpleDateTime;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class CalculatedChartRequest implements RequestInterface {

    @Getter
    @Setter
    private SimpleDateTime simpleDateTime;
    @Getter
    @Setter
    private Location location;
    @Getter
    @Setter
    private int flagValue;
    @Getter
    @Setter
    private int houseSystemId;
    @Getter
    @Setter
    private List<Integer> bodyIds;

}
