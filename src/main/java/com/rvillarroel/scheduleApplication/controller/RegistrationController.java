package com.rvillarroel.scheduleApplication.controller;

import com.rvillarroel.scheduleApplication.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {

    @GetMapping(value = "registration")
    public String getRegistration(@ModelAttribute("registration")Registration registration){

        return "registration";
    }

    @PostMapping(value = "registration")
    public String addRegistration(@ModelAttribute("registration")Registration registration){
        System.out.println("Registration:" + registration.getName());
        return "redirect:registration";
    }


}
