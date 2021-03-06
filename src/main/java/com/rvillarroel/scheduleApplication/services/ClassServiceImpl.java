package com.rvillarroel.scheduleApplication.services;

import com.rvillarroel.scheduleApplication.Repository.ClassRepository;
import com.rvillarroel.scheduleApplication.model.Class;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Service
public class ClassServiceImpl implements ClassService{

    ClassRepository classRepository;

    public ClassServiceImpl(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public Set<Class> getClasses() {
        return classRepository.getAll();
    }

    @Override
    public Class addClass(Class aClass) {
        return classRepository.save(aClass) ;
    }

    @Override
    public boolean deleteClass(Optional<Class> aClass) {
        return classRepository.remove(aClass);
    }

    @Override
    public Optional<Class> findById(String id) {
        return classRepository.findById(id);
    }

    @Override
    public boolean updateClass(Optional<Class> aClass) {
        return classRepository.update(aClass);
    }
}
