package com.kampherbeek.art.json.representation;

public class VersionResponse {

    private final String versionType;
    private final String versionId;

    public VersionResponse(String versionType, String versionId) {
        this.versionType = versionType;
        this.versionId = versionId;
    }

    public String getVersionType() {
        return versionType;
    }

    public String getVersionId() {
        return versionId;
    }
}
