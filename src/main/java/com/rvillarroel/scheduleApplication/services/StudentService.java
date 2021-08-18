package com.rvillarroel.scheduleApplication.services;

import com.rvillarroel.scheduleApplication.model.Class;
import com.rvillarroel.scheduleApplication.model.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

public interface StudentService {
    Collection<Student> getAll();
    Student addStudent(Student student);
    boolean deleteStudent(Optional<Student> student);
    Optional<Student> findById(String id);
    boolean updateStudent(Optional<Student> student);
}
