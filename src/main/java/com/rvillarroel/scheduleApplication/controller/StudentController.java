package com.rvillarroel.scheduleApplication.controller;

import com.rvillarroel.scheduleApplication.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @GetMapping(value = "/students")
    public String getAllStudents(@ModelAttribute("student")Student student){
        return "student";
    }

    @PostMapping(value = "/students")
    public String addStudent(@ModelAttribute("student")Student student){

        System.out.println("Student: " + student.getFirstName());
        return "redirect:student";
    }
}
