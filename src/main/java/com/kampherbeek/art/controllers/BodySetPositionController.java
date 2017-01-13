package com.kampherbeek.art.controllers;

import com.kampherbeek.art.handlers.BodySetPositionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/bodysetposition")
public class BodySetPositionController {

    private final BodySetPositionHandler handler;

    @Autowired
    public BodySetPositionController(BodySetPositionHandler handler) {
        this.handler = handler;
    }

    @RequestMapping(method= RequestMethod.GET)
    public @ResponseBody
    String getBodySetPosition(@RequestParam(value="json") String json) {
        return handler.handleRequest(json);
    }
}
