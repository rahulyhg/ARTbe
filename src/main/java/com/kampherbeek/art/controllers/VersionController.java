package com.kampherbeek.art.controllers;

import com.kampherbeek.art.handlers.VersionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/version")
public class VersionController {

    private final VersionHandler handler;
    private final String shortValue = "{\"versionType\":\"full\"}";

    @Autowired
    public VersionController(VersionHandler handler) {
        this.handler = handler;
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    String getVersion(@RequestParam(value = "json", required = false, defaultValue = shortValue) String json) {
        return handler.handleRequest(json);
    }
}
