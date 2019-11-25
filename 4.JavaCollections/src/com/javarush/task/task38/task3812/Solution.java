package com.javarush.task.task38.task3812;

/* 
Обработка аннотаций
*/

import java.lang.annotation.Annotation;

public class Solution {
    public static void main(String[] args) {
        printFullyQualifiedNames(Solution.class);
        printFullyQualifiedNames(SomeTest.class);

        printValues(Solution.class);
        printValues(SomeTest.class);
    }

    public static boolean printFullyQualifiedNames(Class c) {
        if (!c.isAnnotationPresent(PrepareMyTest.class))
            return false;
        else {
            PrepareMyTest annotation = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            for (String string : annotation.fullyQualifiedNames())
                System.out.println(string);

            return true;
        }
    }

    public static boolean printValues(Class c) {
        if (!c.isAnnotationPresent(PrepareMyTest.class))
            return false;
        else {
            PrepareMyTest annotation = (PrepareMyTest) c.getAnnotation(PrepareMyTest.class);
            for (Class clazz : annotation.value())
                System.out.println(clazz.getSimpleName());
            return true;
        }
    }
}
