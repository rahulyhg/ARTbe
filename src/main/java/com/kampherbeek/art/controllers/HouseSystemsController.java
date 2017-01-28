package com.kampherbeek.art.controllers;

import com.kampherbeek.art.handlers.HouseSystemsHandler;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/housesystems")
public class HouseSystemsController {

    private final HouseSystemsHandler handler;

    @Autowired
    public HouseSystemsController(@NonNull HouseSystemsHandler handler) {
        this.handler = handler;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String retrieveHouseSytems(@RequestParam(value = "json") String json) {
        return handler.handleRequest(json);
    }
}

