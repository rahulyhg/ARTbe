package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.VersionJsonConverter;
import com.kampherbeek.art.json.representation.VersionRequest;
import com.kampherbeek.art.json.representation.VersionResponse;
import com.kampherbeek.art.json.validators.VersionValidator;
import com.kampherbeek.art.util.PropertiesReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.ResourceBundle;

@Component
public class VersionHandler {

    private final VersionValidator validator;
    private final VersionJsonConverter converter;
    private final PropertiesReader reader;
    private final String ERROR_TEXT = "Error in VersionHandler";
    Locale locale = new Locale("EN");
    private ResourceBundle bundle = ResourceBundle.getBundle("messages/messages", locale);

    @Autowired
    public VersionHandler(VersionValidator validator, VersionJsonConverter converter, PropertiesReader reader) {
        this.validator = validator;
        this.converter = converter;
        this.reader = reader;
    }

    public String handleRequest(String requestJson) {
        // TODO externalize
        // TODO remove prefix from resource bundle
        ValidatedObject validatedObject = validator.handleJson(requestJson);
        if (validatedObject.isValid()) {
            String property;
            VersionRequest versionRequest = (VersionRequest)validatedObject.getObject();
            String versionType = versionRequest.getVersionType();
            if (versionType.equalsIgnoreCase("full")) {
                property = "version.full";
            } else {
                property = "version.short";
            }
            String versionLabel = bundle.getString("version");
            String versionId = versionLabel + " " +reader.getValueForProperty(property);
            VersionResponse response = new VersionResponse(versionType, versionId);
            try {
                return converter.java2JsonResponse(response);
            } catch (JsonProcessingException e) {
                return ERROR_TEXT;
            }
        }
        return ERROR_TEXT;
    }

}
