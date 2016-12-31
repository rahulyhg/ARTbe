package com.kampherbeek.art.controllers;

import com.kampherbeek.art.handlers.HousePositionsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/housepositions")
/**
 * Request all housepositions, including MC, Asc, Vertex, Eastpoint.
 * You can call the API with [server]:[port]/housepositions?
 *      json='{"system":12,"jdnr":2457139.8,"location":{"longitude":6.9,"latitude":52.23}}
 */
public class HousePositionsController {

    private final HousePositionsHandler handler;

    @Autowired
    public HousePositionsController(HousePositionsHandler handler) {
        this.handler = handler;
    }

    @RequestMapping(method= RequestMethod.GET)
    public @ResponseBody
    String getHousePositions(@RequestParam(value="json") String json) {
        return handler.handleRequest(json);
    }
}
