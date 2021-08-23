package com.rvillarroel.scheduleApplication.services;

import com.rvillarroel.scheduleApplication.Repository.StudentRepository;
import com.rvillarroel.scheduleApplication.model.Class;
import com.rvillarroel.scheduleApplication.model.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService{

    StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Set<Student> getAll() {
        return studentRepository.getAll();
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public boolean deleteStudent(Optional<Student> student) {
        return studentRepository.remove(student);
    }

    @Override
    public Optional<Student> findById(String id) {
        return studentRepository.findById(id);
    }

    @Override
    public boolean updateStudent(Optional<Student> student) {
        return studentRepository.update(student);
    }
}
