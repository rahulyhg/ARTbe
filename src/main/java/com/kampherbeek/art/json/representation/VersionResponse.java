package com.kampherbeek.art.json.representation;

import lombok.Getter;
import lombok.NonNull;

public class VersionResponse implements ResponseInterface {

    @Getter
    private final String versionType;
    @Getter
    private final String versionId;

    public VersionResponse(@NonNull final String versionType, @NonNull final String versionId) {
        this.versionType = versionType;
        this.versionId = versionId;
    }

}
