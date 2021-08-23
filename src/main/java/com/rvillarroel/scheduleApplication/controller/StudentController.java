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

import java.util.*;

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
//        model.addAttribute("classList", classService.getClasses());

        return "student";
    }

    @PostMapping(value = "/student")
    public String addStudent(@ModelAttribute("student")Student student){

        if (!student.getFirstName().isEmpty() && !student.getLastName().isEmpty()){
            studentService.addStudent(student);
        }

        return "redirect:student";
    }

    @GetMapping(value = "/student/search")
    public String searchClasses(@ModelAttribute("student")Student student, Model model){

        if (!student.getFirstName().isEmpty()) {

            Optional<Student> searh = Optional.ofNullable(studentService.getAll()
                    .stream()
                    .filter(student1 -> student1.getFirstName().equals(student.getFirstName())
                    ).findAny().orElse(null));

            model.addAttribute("studentList", Arrays.asList(searh.get()));

            if (searh.isPresent())
                model.addAttribute("studentList", Arrays.asList(searh.get()));

        }else {
            return "redirect:/student";
        }

        return "student";
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

    @GetMapping(value = "/student/{id}/classes")
    public String viewStudentClasses(@PathVariable String id, Model model){

        Optional<Student> student = studentService.findById(id);
        if (student.isPresent()) {

            model.addAttribute("student", student);
            model.addAttribute("classList", classService.getClasses());
            model.addAttribute("studentClassList", student.get().getClasses());
        }
        return "/studentClasses";
    }

    @PostMapping(value = "/student/{id}/classes")
    public String addStudentClasses(@ModelAttribute("class")String classId, @PathVariable String id, Model model){

        Optional<Student> student1 = studentService.findById(id);

        if (student1.isPresent()) {
            Optional<Class> addClass = classService.findById(classId);

            student1.get().getClasses().add(addClass.get());
            studentService.updateStudent(student1);

            model.addAttribute("student", student1);
            model.addAttribute("classList", classService.getClasses());
            model.addAttribute("studentClassList", student1.get().getClasses());
        }
        return "/studentClasses";
    }

    @GetMapping(value = "/student/{id}/classes/{classId}/delete")
    public String deleteStudentClasses(@PathVariable String id, @PathVariable String classId, Model model){

        Optional<Student> student = studentService.findById(id);

        if (student.isPresent()) {

            student.get().getClasses().remove(classService.findById(classId).get());

            model.addAttribute("student", student);
            model.addAttribute("classList", classService.getClasses());
            model.addAttribute("studentClassList", student.get().getClasses());

        }
        return "redirect:/student/" + student.get().getId() + "/classes";
    }

}
