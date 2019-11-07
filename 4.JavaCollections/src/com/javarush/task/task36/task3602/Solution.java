package com.javarush.task.task36.task3602;

import java.awt.*;
import java.lang.reflect.Modifier;

/*
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(getExpectedClass());
    }

    private static boolean isPrivateStatic(Class<?> clazz) {
//        1 - public
//        2 - private
//        4 - protected
//        8 - static
        return (clazz.getModifiers() == (Modifier.PRIVATE | Modifier.STATIC));
    }

    private static boolean isAssignableFrom(Class<?> clazz) {
        return clazz.isAssignableFrom(List.class);
    }

    private static Class<?>[] getInterfeces(Class<?> clazz) {
        return clazz.getInterfaces();
    }

    public static Class getExpectedClass() throws ClassNotFoundException {
        Class clazz = Class.forName("java.util.Collections");
        Class<?>[] classes = clazz.getDeclaredClasses();

        for (Class<?> entryClass : classes) {
            if (isPrivateStatic(entryClass)) {
                System.out.println("Class: " + entryClass.getSimpleName());
                System.out.println("Interfeces list:");
                Class<?>[] classesInt = getInterfeces(entryClass);
                for (Class<?> entryInt: classesInt) {
                    System.out.println(entryInt.getSimpleName());
                }
                Class<?> ttt = entryClass.getSuperclass();
                System.out.println("SuperClass: " + entryClass.getSuperclass().getSimpleName());
                Class<?>[] superInt = getInterfeces(ttt);
                for (Class<?> entryInt: superInt) {
                    System.out.println(entryInt.getSimpleName());
                }
                System.out.println("-----------------------------");
            }
//            System.out.println(entry.getModifiers());
//            System.out.println("---------------");
        }


        return null;
    }
}
