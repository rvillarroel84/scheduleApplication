package com.rvillarroel.scheduleApplication.services;

import com.rvillarroel.scheduleApplication.Repository.StudentRepository;
import com.rvillarroel.scheduleApplication.model.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentServiceImpl implements StudentService{

    StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Collection<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }
}
