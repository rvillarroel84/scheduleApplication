package com.rvillarroel.scheduleApplication.Repository;

import com.rvillarroel.scheduleApplication.model.Class;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class ClassRepository {

    private Set<Class> classes=new HashSet<>();

    public Set<Class> getAll(){
        return classes;
    }

    public Class save(Class aClass){
        classes.add(aClass);
        return  aClass;
    }
    public Optional<Class> findById(String id){

        return classes.stream().filter(aClass -> aClass.getId().equals(id)).findFirst();
    }
    public boolean remove(Optional<Class> aClass){
        return classes.removeIf(aClass1 -> aClass1.getId().equals(aClass.get().getId()));
    }
}
