package com.kampherbeek.art.json.representation;

public class StandardSelectionItem {

    private final String id;
    private final String value;

    public StandardSelectionItem(final String id, final String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
