package com.kampherbeek.art.controllers;

import com.kampherbeek.art.handlers.BodynamesHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bodynames")
public class BodynamesController {
    /**
     * Returns list of available (virtual) bodies.
     * You can call API with [server]:[port]/bodynames?json={"locale":"en"}  (or "nl" and not "en")
     */
    private final BodynamesHandler handler;

    @Autowired
    public BodynamesController(BodynamesHandler handler) {
        this.handler = handler;
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    String getBodyNames(@RequestParam(value = "json") String json) {
        return handler.handleRequest(json);
    }
}
