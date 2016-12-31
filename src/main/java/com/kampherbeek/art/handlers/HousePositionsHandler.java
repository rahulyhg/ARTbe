package com.kampherbeek.art.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kampherbeek.art.json.ValidatedObject;
import com.kampherbeek.art.json.converters.HousePositionsJsonConverter;
import com.kampherbeek.art.json.representation.HousePositionsRequest;
import com.kampherbeek.art.json.representation.HousePositionsResponse;
import com.kampherbeek.art.json.validators.HousePositionsValidator;
import com.kampherbeek.art.json.validators.VersionValidator;
import com.kampherbeek.art.solvers.HousePositionsSolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HousePositionsHandler {

    private static final Logger LOG = LoggerFactory.getLogger(VersionValidator.class);
    private final HousePositionsValidator validator;
    private final HousePositionsJsonConverter converter;
    private final HousePositionsSolver solver;
    private final String ERROR_TEXT = "Error in HousePositionsHandler";

    @Autowired
    public HousePositionsHandler(HousePositionsValidator validator, HousePositionsJsonConverter converter,
                                 HousePositionsSolver solver) {
        this.validator = validator;
        this.converter = converter;
        this.solver = solver;
    }

    public String handleRequest(String requestJson) {
        ValidatedObject validatedObject = validator.handleJson(requestJson, converter);
        if (validatedObject.isValid()) {
            HousePositionsResponse response =  solver.solveRequest((HousePositionsRequest) validatedObject.getObject());
            try {
                return converter.java2JsonResponse(response);
            } catch (JsonProcessingException e) {
                LOG.error("HousePositionsHandler: " + e.getMessage());
                return ERROR_TEXT;
            }
        }
        return ERROR_TEXT;
    }


}
