package com.kampherbeek.art.json.representation;

public class VersionRequest {

    private String versionType;

    public VersionRequest(){
        this.versionType = "Short";
    };

    public void setVersionType(String versionType) {
        this.versionType = versionType;
    }

    public String getVersionType() {
        return versionType;
    }
}
