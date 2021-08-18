package com.rvillarroel.scheduleApplication.Repository;

import com.rvillarroel.scheduleApplication.model.Class;
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
        return students.stream().filter(student -> student.getId().equals(id)).findFirst();
    }
    public boolean remove(Optional<Student> student){
        return students.removeIf(student1 -> student1.getId().equals(student.get().getId()));
    }
    public boolean update(Optional<Student> student){

        boolean removeItem =  students.removeIf(student1 -> student1.getId().equals(student.get().getId()));
        if (removeItem) students.add(student.get());

        return removeItem;
    }


}
