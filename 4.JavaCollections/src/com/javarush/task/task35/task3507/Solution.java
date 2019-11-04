package com.javarush.task.task35.task3507;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* 
ClassLoader - что это такое?
*/
public class Solution {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Set<Animal> classSet = new HashSet<>();
        DynamicClassOverloader myClassLoader = new DynamicClassOverloader();
        File[] files = new File(pathToAnimals).listFiles();

        for (File file : files) {
            Class clazz = myClassLoader.findClass(file.getAbsolutePath());
            Constructor[] constructors = clazz.getConstructors();
            for (Constructor constructor : constructors) {
                if (constructor.getParameterCount() == 0) {
                    if (Animal.class.isAssignableFrom(clazz)) {
                        classSet.add((Animal) constructor.newInstance());
                        break;
                    }
                }
            }
        }
        return classSet;
    }

    public static class DynamicClassOverloader extends ClassLoader {

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            Class result = null;
            File file = new File(name);
            byte[] classBytes = new byte[(int)file.length()];
            try {
                new FileInputStream(file).read(classBytes);
                result = defineClass(null, classBytes, 0,
                        classBytes.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }
    }

    static class Cat {

    }
}
