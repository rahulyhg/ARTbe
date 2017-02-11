package com.kampherbeek.art.json.representation;

import lombok.Getter;
import lombok.NonNull;

import java.util.List;

public class EphemerisFilesResponse implements ResponseInterface {

    @Getter
    private final boolean filesOk;
    @Getter
    private final List<String> missingFiles;

    public EphemerisFilesResponse(boolean filesOk, @NonNull List<String> missingFiles) {
        this.filesOk = filesOk;
        this.missingFiles = missingFiles;
    }
}
