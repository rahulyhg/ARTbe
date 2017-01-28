package com.kampherbeek.art.json.representation;

import com.kampherbeek.art.domain.SimpleDateTime;
import lombok.Getter;
import lombok.Setter;

public class JdnrRequest implements RequestInterface {

    @Getter @Setter
    private SimpleDateTime simpleDateTime;

}
