package com.kampherbeek.art.json.validators;

import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.VersionJsonConverter;
import com.kampherbeek.art.json.representation.VersionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class VersionValidator {

    private static final Logger LOG = LoggerFactory.getLogger(VersionValidator.class);
    private final VersionJsonConverter converter;
    private final String shortType = "Short";
    private final String fullType = "Full";

    @Autowired
    public VersionValidator(VersionJsonConverter converter) {
        this.converter = converter;
    }


    public ValidatedObject handleJson(String jsonInput) {
        try {
            VersionRequest versionRequest = converter.jsonRequest2Java(jsonInput);
            if (isValid(versionRequest.getVersionType())) {
                return new ValidatedObject(true, versionRequest);
            } else {
                return new ValidatedObject(false, "Wrong value.");
            }
        } catch (IOException e) {
            LOG.error(String.format("IOExeption when processing JSON : %s . Message : %s", jsonInput, e.getMessage()));
            return new ValidatedObject(false, e.getMessage());
        }
    }



    private boolean isValid(String versionType) {
        return (versionType.equalsIgnoreCase(shortType) || versionType.equalsIgnoreCase(fullType));
    }



}
