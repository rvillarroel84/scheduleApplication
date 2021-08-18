package com.rvillarroel.scheduleApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class GreetingController {

    @GetMapping( value = "/greeting")
    public  String greeting(Map<String, Object> model){
        model.put("message", "Hello Ronny");
        return "greeting";
    }
}
