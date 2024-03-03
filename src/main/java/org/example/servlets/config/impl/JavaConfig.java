package org.example.servlets.config.impl;

import org.example.servlets.config.Config;
import org.reflections.Reflections;

import java.util.Set;

public class JavaConfig implements Config {
    private Reflections scanner;

    public JavaConfig(String packageToScan) {
        scanner = new Reflections(packageToScan);
    }


    @Override
    public <T> Class<? extends T> getImplClass(Class<T> ifc) {
        Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
        if(classes.size() != 1) throw new RuntimeException("There can only be one impl");
        return classes.iterator().next();
    }
}
