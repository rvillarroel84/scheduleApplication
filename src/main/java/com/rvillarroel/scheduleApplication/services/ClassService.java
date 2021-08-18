package com.rvillarroel.scheduleApplication.services;

import com.rvillarroel.scheduleApplication.model.Class;

import java.util.Collection;
import java.util.Optional;

public interface ClassService {

    Collection<Class> getClasses();
    Class addClass(Class aClass);
    boolean deleteClass(Optional<Class> aClass);
    Optional<Class> findById(String id);
}
