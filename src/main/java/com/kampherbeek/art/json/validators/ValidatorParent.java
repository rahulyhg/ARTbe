package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.ConverterParent;
import com.kampherbeek.art.json.representation.RequestInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public abstract class ValidatorParent {

    private static final Logger LOG = LoggerFactory.getLogger(VersionValidator.class);

    public ValidatedObject handleJson(String jsonInput, ConverterParent converter) {
        try {
            RequestInterface request = converter.jsonRequest2Java(jsonInput);
            if (isValid(request)) {
                return new ValidatedObject(true, request);
            } else {
                return new ValidatedObject(false, "Wrong value.");
            }
        } catch (IOException e) {
            LOG.error(String.format("ValidatedObject. IOExeption when processing JSON : %s . Message : %s", jsonInput, e.getMessage()));
            return new ValidatedObject(false, e.getMessage());
        }
    }

    protected abstract boolean isValid(RequestInterface request);
}
