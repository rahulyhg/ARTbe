package com.kampherbeek.art.controllers;

import com.kampherbeek.art.handlers.HouseSystemsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/housesystems")
/**
 * Returns list of available house systems.
 * You can call API with [server]:[port]/housesystems?json={"locale":"en"}  (or "nl" and not "en")
 */
public class HouseSystemsController {

    private final HouseSystemsHandler handler;

    @Autowired
    public HouseSystemsController(HouseSystemsHandler handler)  {
        this.handler = handler;
    }

    @RequestMapping(method= RequestMethod.GET)
    public @ResponseBody
    String getHouseSytems(@RequestParam(value="json", required=true) String json) {
        return handler.handleRequest(json);
    }
}

