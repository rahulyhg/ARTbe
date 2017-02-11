package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.converters.NoParamJsonConverter;
import com.kampherbeek.art.json.representation.SettingsResponse;
import com.kampherbeek.art.solvers.SettingsSolver;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class SettingsHandler {

    private final NoParamJsonConverter converter;
    private final SettingsSolver solver;
    private static final Logger LOG = LoggerFactory.getLogger(SettingsHandler.class);

    @Autowired
    public SettingsHandler(@NonNull NoParamJsonConverter converter,
                           @NonNull SettingsSolver solver) {
        this.converter = converter;
        this.solver = solver;
    }

    public String handleRequest() {
        String errorText = "Error in SettingsHandler";
        SettingsResponse response = solver.solveRequest();
        try {
            return converter.java2JsonResponse(response);
        } catch (JsonProcessingException e) {
            LOG.error("Exception: " + e);
            return errorText;
        }
    }
}
