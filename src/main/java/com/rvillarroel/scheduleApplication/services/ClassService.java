package com.rvillarroel.scheduleApplication.services;

import com.rvillarroel.scheduleApplication.model.Class;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface ClassService {

    Set<Class> getClasses();
    Class addClass(Class aClass);
    boolean deleteClass(Optional<Class> aClass);
    Optional<Class> findById(String id);
    boolean updateClass(Optional<Class> aClass);
}
