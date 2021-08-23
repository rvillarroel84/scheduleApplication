package com.rvillarroel.scheduleApplication.controller;

import com.rvillarroel.scheduleApplication.model.Class;
import com.rvillarroel.scheduleApplication.model.Student;
import com.rvillarroel.scheduleApplication.services.ClassService;
import com.rvillarroel.scheduleApplication.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

@Controller
public class ClassController {

    ClassService classService;
    StudentService studentService;

    public ClassController(ClassService classService, StudentService studentService) {
        this.classService = classService;
        this.studentService = studentService;
    }


    @GetMapping(value = "/class")
    public String getAllClasses(@ModelAttribute("class")Class classes, Model model){


        model.addAttribute("classList", classService.getClasses());

        return "class";
    }

    @GetMapping(value = "/class/search")
    public String searchClasses(@ModelAttribute("class")Class classes, Model model){

        if (!classes.getCode().isEmpty()) {

            Optional<Class> searh = Optional.ofNullable(classService.getClasses()
                                                .stream()
                                                .filter(aClass -> aClass.getCode().equals(classes.getCode())
                                                ).findAny().orElse(null));

            if (searh.isPresent())
                model.addAttribute("classList", Arrays.asList(searh.get()));

        }else {
            return "redirect:/class";
        }

        return "/class";
    }

    @PostMapping(value = "/class")
    public String addClass(@ModelAttribute("class") Class classes){

        if (!classes.getCode().isEmpty() && !classes.getTitle().isEmpty()) {
            classService.addClass(classes);
        }
        return "redirect:class";
    }

    @PostMapping(value = "/class/{id}/update")
    public String addClass(@ModelAttribute("class") Class classes, Model model){

        classService.updateClass(Optional.ofNullable(classes));

        return "redirect:/class";
    }

    @GetMapping(value = "/class/{id}/delete")
    public String deleteClass(@PathVariable String id){

        Optional<Class> aClass = classService.findById(id);
        if (aClass.isPresent()) {
            classService.deleteClass(aClass);
        }
        return "redirect:/class";
    }

    @GetMapping(value = "/class/{id}/update")
    public String updateClass(@ModelAttribute("class") Class classes, @PathVariable String id, Model model){

        Optional<Class> aClass = classService.findById(id);
        if (aClass.isPresent()) {
            model.addAttribute("editClass", aClass);
        }
        return "/classEdit";
    }



    @GetMapping(value = "/class/{id}/students")
    public String viewClassStudents(@PathVariable String id, Model model){

        Optional<Class> aClass = classService.findById(id);

        if (aClass.isPresent()) {

            model.addAttribute("class", aClass);
            model.addAttribute("studentList", studentService.getAll());
            model.addAttribute("classStudentList", aClass.get().getStudents());
        }
        return "/classStudents";
    }

    @PostMapping(value = "/class/{id}/students")
    public String addClassStudent(@ModelAttribute("students")String studentId, @PathVariable String id, Model model){

        Optional<Class> aClass = classService.findById(id);

        if (aClass.isPresent()) {
            Optional<Student> addStudent = studentService.findById(studentId);

            if (addStudent.isPresent()) {
                aClass.get().getStudents().add(addStudent.get());
                classService.updateClass(aClass);
            }

            model.addAttribute("class", aClass);
            model.addAttribute("studentList", studentService.getAll());
            model.addAttribute("classStudentList", aClass.get().getStudents());


        }
        return "/classStudents";
    }

    @GetMapping(value = "/class/{id}/student/{studentId}/delete")
    public String deleteClassStudent(@PathVariable String id, @PathVariable String studentId, Model model){

        Optional<Class> aClass = classService.findById(id);

        if (aClass.isPresent()) {

            aClass.get().getStudents().remove(studentService.findById(studentId).get());

            model.addAttribute("class", aClass);
            model.addAttribute("studentList", classService.getClasses());
            model.addAttribute("classStudentList", aClass.get().getStudents());

        }
        return "redirect:/class/" + aClass.get().getId() + "/students";
    }




}
