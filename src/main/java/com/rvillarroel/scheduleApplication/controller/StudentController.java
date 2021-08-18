package com.rvillarroel.scheduleApplication.controller;

import com.rvillarroel.scheduleApplication.model.Class;
import com.rvillarroel.scheduleApplication.model.Student;
import com.rvillarroel.scheduleApplication.services.ClassService;
import com.rvillarroel.scheduleApplication.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

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

    @PostMapping(value = "/student/{id}/update")
    public String updateStudent(@ModelAttribute("student") Student student, Model model){

        studentService.updateStudent(Optional.ofNullable(student));

        return "redirect:/student";
    }

    @GetMapping(value = "/student/{id}/delete")
    public String deleteClass(@PathVariable String id){

        Optional<Student> student = studentService.findById(id);
        if (student.isPresent()) {
            studentService.deleteStudent(student);
        }

        return "redirect:/student";
    }

    @GetMapping(value = "/student/{id}/update")
    public String updateStudent(@ModelAttribute("student") Student student, @PathVariable String id, Model model){

        Optional<Student> student1 = studentService.findById(id);
        if (student1.isPresent()) {
            model.addAttribute("editStudent", student1);
            model.addAttribute("classList", classService.getClasses());
        }
        return "/studentEdit";
    }
}
