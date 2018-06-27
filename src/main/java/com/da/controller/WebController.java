package com.da.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class WebController {

    @RequestMapping("/home")
    public String home() {
        return "index";
    }
}
