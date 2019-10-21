package com.javarush.task.task35.task3512;

public class Generator<T> {
    private Class<T> fieldClass;

    public Generator(Class<T> eventClass) {
        this.fieldClass = eventClass;
    }

    T newInstance() throws IllegalAccessException, InstantiationException {
        return fieldClass.newInstance();
    }
}
