package com.kampherbeek.art.json.representation;

public class VersionRequest implements RequestInterface {

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
