package com.kampherbeek.art.json.representation;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class BodySetPositionRequest implements RequestInterface {

    @Getter
    @Setter
    private double jdnr;
    @Getter
    @Setter
    private int flagValue;
    @Getter
    @Setter
    private List<Integer> internalIds;
}
