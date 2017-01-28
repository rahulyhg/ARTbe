package com.kampherbeek.art.json.representation;

import lombok.Getter;
import lombok.Setter;

public class VersionRequest implements RequestInterface {

    @Getter
    @Setter
    private String versionType;

    public VersionRequest() {
        this.versionType = "Short";
    }

}
