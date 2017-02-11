package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.converters.NoParamJsonConverter;
import com.kampherbeek.art.json.representation.EphemerisFilesResponse;
import com.kampherbeek.art.solvers.EphemerisFilesSolver;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EphemerisFilesHandler {

    private final NoParamJsonConverter converter;
    private final EphemerisFilesSolver solver;
    private static final Logger LOG = LoggerFactory.getLogger(EphemerisFilesHandler.class);

    @Autowired
    public EphemerisFilesHandler(@NonNull NoParamJsonConverter converter, @NonNull EphemerisFilesSolver solver) {
        this.converter = converter;
        this.solver = solver;
    }

    public String handleRequest() {
        String errorText = "Error in EphemerisFilesHandler";
        EphemerisFilesResponse response = solver.solveRequest();
        try {
            return converter.java2JsonResponse(response);
        } catch (JsonProcessingException e) {
            LOG.error("Exception: " + e);
            return errorText;
        }
    }

}
