package com.rvillarroel.scheduleApplication.bootstrap;

import com.rvillarroel.scheduleApplication.model.Class;
import com.rvillarroel.scheduleApplication.model.Student;
import com.rvillarroel.scheduleApplication.services.ClassService;
import com.rvillarroel.scheduleApplication.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Component
public class BootStrapData implements CommandLineRunner {


    ClassService classService;
    StudentService studentService;

    public BootStrapData(ClassService classService, StudentService studentService) {
        this.classService = classService;
        this.studentService = studentService;
    }

    @Override
    public void run(String... args) throws Exception {

        Student ronny = new Student("Villarroel", "Ronny");
        Class springMVC = new Class("SPMVC", "Spring Framework 5: Beginner to Guru", "test");
        ronny.getClasses().add(springMVC);
        springMVC.getStudents().add(ronny);

        classService.addClass(springMVC);
        studentService.addStudent(ronny);

        Student rolando = new Student("Cardozo", "Rolando");
        rolando.getClasses().add(springMVC);
        springMVC.getStudents().add(rolando);

        classService.addClass(springMVC);
        studentService.addStudent(ronny);


        Student oliver = new Student("Villarroel", "Oliver");
        Class agileClass = new Class("Agile", "Agile Framework: Beginner to Guru", "test");
        oliver.getClasses().add(agileClass);
        agileClass.getStudents().add(oliver);

        classService.addClass(agileClass);
        studentService.addStudent(oliver);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of classes: " + oliver.getClass());




    }
}
