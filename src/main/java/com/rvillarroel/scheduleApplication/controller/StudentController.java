package com.rvillarroel.scheduleApplication.controller;

import com.rvillarroel.scheduleApplication.model.Student;
import com.rvillarroel.scheduleApplication.services.ClassService;
import com.rvillarroel.scheduleApplication.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    ClassService classService;
    StudentService studentService;

    public StudentController(ClassService classService, StudentService studentService) {
        this.classService = classService;
        this.studentService = studentService;
    }

    @GetMapping(value = "/student")
    public String getAllStudents(@ModelAttribute("student")Student student, Model model){

        model.addAttribute("studentList", studentService.getAll());
        model.addAttribute("classList", classService.getClasses());

        return "student";
    }

    @PostMapping(value = "/student")
    public String addStudent(@ModelAttribute("student")Student student){

        studentService.addStudent(student);
        System.out.println("Student: " + student.getFirstName());
        return "redirect:student";
    }
}
