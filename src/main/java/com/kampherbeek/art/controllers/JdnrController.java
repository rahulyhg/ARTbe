package com.kampherbeek.art.controllers;

import com.kampherbeek.art.handlers.JdnrHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/jdnr")
public class JdnrController {

    private final JdnrHandler handler;

    @Autowired
    public JdnrController(JdnrHandler handler) {
        this.handler = handler;
    }

    @RequestMapping(method = RequestMethod.GET)
    public
    @ResponseBody
    String getJdnr(@RequestParam(value = "json") String json) {
        return handler.handleRequest(json);
    }
}
