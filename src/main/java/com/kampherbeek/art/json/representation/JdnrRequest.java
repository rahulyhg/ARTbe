package com.kampherbeek.art.json.representation;

import com.kampherbeek.art.domain.SimpleDateTime;

public class JdnrRequest implements RequestInterface{

    private SimpleDateTime simpleDateTime;

    public SimpleDateTime getSimpleDateTime() {
        return simpleDateTime;
    }

    public void setSimpleDateTime(SimpleDateTime simpleDateTime) {
        this.simpleDateTime = simpleDateTime;
    }
}
