package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.ConverterParent;
import com.kampherbeek.art.json.representation.RequestInterface;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public abstract class ValidatorParent {

    private static final Logger LOG = LoggerFactory.getLogger(ValidatorParent.class);

    public ValidatedObject handleJson(@NonNull final String jsonInput,
                                      @NonNull final ConverterParent converter) {
        try {
            RequestInterface request = converter.jsonRequest2Java(jsonInput);
            if (validated(request)) {
                return new ValidatedObject(true, request);
            } else {
                return new ValidatedObject(false, "Wrong value.");
            }
        } catch (IOException e) {
            LOG.error(String.format("IOExeption when processing JSON : %s . Message : %s", jsonInput, e));
            return new ValidatedObject(false, e.getMessage());
        }
    }

    protected abstract boolean validated(@NonNull final RequestInterface request);
}
