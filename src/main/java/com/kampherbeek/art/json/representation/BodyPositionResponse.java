package com.kampherbeek.art.json.representation;

import com.kampherbeek.art.domain.BodyPosition;
import com.kampherbeek.art.domain.Bodynames;
import lombok.Getter;
import lombok.NonNull;

public class BodyPositionResponse implements ResponseInterface {

    @Getter
    private final BodyPosition position;
    @Getter
    private final Bodynames bodyname;

    public BodyPositionResponse(@NonNull final Bodynames bodyname, @NonNull BodyPosition position) {
        this.bodyname = bodyname;
        this.position = position;
    }

}
