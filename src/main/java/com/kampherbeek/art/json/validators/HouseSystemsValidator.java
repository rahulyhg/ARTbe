package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.HouseSystemsJsonConverter;
import com.kampherbeek.art.json.representation.HouseSystemsRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HouseSystemsValidator {

    private static final Logger LOG = LoggerFactory.getLogger(VersionValidator.class);
    private final String LOCALE_EN = "en";
    private final String LOCALE_NL = "nl";
    private final HouseSystemsJsonConverter converter;

    @Autowired
    public HouseSystemsValidator(HouseSystemsJsonConverter converter) {
        this.converter = converter;
    }

    public ValidatedObject handleJson(String jsonInput) {
        try {
            HouseSystemsRequest request = converter.jsonRequest2Java(jsonInput);
            if (isValid(request.getLocale())) {
                return new ValidatedObject(true, request);
            } else {
                return new ValidatedObject(false, "Wrong value.");
            }
        } catch (IOException e) {
            LOG.error(String.format("IOExeption when processing JSON : %s . Message : %s", jsonInput, e.getMessage()));
            return new ValidatedObject(false, e.getMessage());
        }
    }

    private boolean isValid(String locale) {
        return (locale.equalsIgnoreCase(LOCALE_EN) || locale.equalsIgnoreCase(LOCALE_NL));
    }

}
