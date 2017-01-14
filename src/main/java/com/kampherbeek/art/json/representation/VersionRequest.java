package com.kampherbeek.art.json.representation;

public class VersionRequest implements RequestInterface {

    private String versionType;

    public VersionRequest() {
        this.versionType = "Short";
    }

    public String getVersionType() {
        return versionType;
    }

    public void setVersionType(String versionType) {
        this.versionType = versionType;
    }
}
