package com.kampherbeek.art.json.representation;

import com.kampherbeek.art.domain.BodyPosition;
import com.kampherbeek.art.domain.Bodynames;

public class BodyPositionResponse implements ResponseInterface{

    private BodyPosition position;
    private Bodynames bodyname;

    public BodyPositionResponse(Bodynames bodyname, BodyPosition position) {
        this.bodyname = bodyname;
        this.position = position;
    }

    public BodyPosition getPosition() {
        return position;
    }


    public Bodynames getBodyname() {
        return bodyname;
    }

}
