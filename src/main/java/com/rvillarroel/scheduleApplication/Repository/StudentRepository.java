package com.rvillarroel.scheduleApplication.Repository;

import com.rvillarroel.scheduleApplication.model.Student;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentRepository {

    private Set<Student> students = new HashSet<>();

    public Set<Student> getAll(){
        return students;
    }
    public Student save(Student student){
        student.setId(UUID.randomUUID().toString());
        students.add(student);
        return  student;
    }
    public Optional<Student> findById(String id){
        return students.stream().filter(student -> student.getId() == id).findFirst();
    }


}
