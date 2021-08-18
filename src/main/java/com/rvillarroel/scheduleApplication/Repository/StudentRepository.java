package com.rvillarroel.scheduleApplication.Repository;

import com.rvillarroel.scheduleApplication.model.Student;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentRepository {

    private Set<Student> students = new HashSet<>();

    public Set<Student> getAll(){
        return students;
    }
    public Student save(Student student){
        students.add(student);
        return  student;
    }
    public Optional<Student> findById(String id){
        return students.stream().filter(student -> student.getId() == id).findFirst();
    }


}
