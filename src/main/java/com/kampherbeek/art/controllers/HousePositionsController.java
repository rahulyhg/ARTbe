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
public class HousePositionsController {

    private final HousePositionsHandler handler;

    @Autowired
    public HousePositionsController(HousePositionsHandler handler) {
        this.handler = handler;
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    String getHousePositions(@RequestParam(value = "json") String json) {
        return handler.handleRequest(json);
    }
}
