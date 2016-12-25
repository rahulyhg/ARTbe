package com.kampherbeek.art.json;

public class ValidatedObject {

    private final boolean isValid;
    private final Object object;

    public ValidatedObject(boolean isValid, Object object) {
        this.isValid = isValid;
        this.object = object;
    }

    public boolean isValid() {
        return isValid;
    }

    public Object getObject() {
        return object;
    }
}
