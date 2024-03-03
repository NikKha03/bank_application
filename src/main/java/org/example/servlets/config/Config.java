package org.example.servlets.config;

public interface Config {
    <T> Class<? extends T> getImplClass(Class<T> ifc);
}
