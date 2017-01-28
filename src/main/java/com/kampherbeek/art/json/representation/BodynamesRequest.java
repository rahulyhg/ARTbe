package com.kampherbeek.art.json.representation;

import lombok.Getter;
import lombok.Setter;

public class BodynamesRequest implements RequestLookupInterface {

    @Getter @Setter
    private String locale = "en";
}
