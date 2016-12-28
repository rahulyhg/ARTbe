package com.kampherbeek.art.json.representation;

public class BodynamesRequest implements RequestLookupInterface {

    private String locale = "en";

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getLocale() {
        return locale;
    }
}
