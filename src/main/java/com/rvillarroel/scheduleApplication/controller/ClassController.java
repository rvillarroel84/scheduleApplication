package com.rvillarroel.scheduleApplication.controller;

import com.rvillarroel.scheduleApplication.model.Class;
import com.rvillarroel.scheduleApplication.services.ClassService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class ClassController {

    ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }

    @GetMapping(value = "/class")
    public String getAllClasses(@ModelAttribute("class")Class classes, Model model){

        System.out.println("Nro. Classes: " + classService.getClasses().size());
        model.addAttribute("classList", classService.getClasses());

        return "class";
    }

    @PostMapping(value = "/class")
    public String addClass(@ModelAttribute("class") Class classes){
        System.out.println("Class: " + classes.getCode());
        classService.addClass(classes);
        return "redirect:class";
    }

    @GetMapping(value = "/class/{id}/delete")
    public String deleteClass(@PathVariable String id){

        Optional<Class> aClass = classService.findById(id);
        if (aClass.isPresent()) {
            classService.deleteClass(aClass);
        }
        System.out.println("Elimino Cantidad: " + classService.getClasses().size());
        return "redirect:/class";
    }

    @GetMapping(value = "/class/{id}/update")
    public String deleteClass(@PathVariable String id, Model model){

        Optional<Class> aClass = classService.findById(id);
        if (aClass.isPresent()) {
            model.addAttribute("classe", aClass);
        }
        return "redirect:/classEdit";
    }




}
