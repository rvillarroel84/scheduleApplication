package com.rvillarroel.scheduleApplication.services;

import com.rvillarroel.scheduleApplication.model.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface StudentService {
    Collection<Student> getAll();
    Student addStudent(Student student);
}
