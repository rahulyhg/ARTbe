package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.HouseSystemsJsonConverter;
import com.kampherbeek.art.json.representation.HouseSystemsRequest;
import com.kampherbeek.art.json.representation.HouseSystemsResponse;
import com.kampherbeek.art.json.validators.LookupListValidator;
import com.kampherbeek.art.json.validators.VersionValidator;
import com.kampherbeek.art.solvers.HouseSystemsSolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HouseSystemsHandler {

    private static final Logger LOG = LoggerFactory.getLogger(VersionValidator.class);
    private final LookupListValidator validator;
    private final HouseSystemsJsonConverter converter;
    private final HouseSystemsSolver solver;
    private final String ERROR_TEXT = "Error in HouseSystemsHandler";

    @Autowired
    public HouseSystemsHandler(final LookupListValidator validator,
                               final HouseSystemsJsonConverter converter,
                               final HouseSystemsSolver solver) {
        this.validator = validator;
        this.converter = converter;
        this.solver = solver;
    }

    public String handleRequest(String requestJson) {

        ValidatedObject validatedObject = validator.handleJson(requestJson, converter);
        if (validatedObject.isValid()) {
            HouseSystemsResponse response = solver.solveRequest((HouseSystemsRequest) validatedObject.getObject());
            try {
                return converter.java2JsonResponse(response);
            } catch (JsonProcessingException e) {
                LOG.error("HouseSysemsHandler: " + e.getMessage());
                return ERROR_TEXT;
            }
        }
        return ERROR_TEXT;
    }

}
