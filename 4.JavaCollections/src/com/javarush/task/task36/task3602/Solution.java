package com.javarush.task.task36.task3602;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/* 
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println(getExpectedClass());
    }

    private static boolean isExtendListInterface(Class<?>[] interfaces) {
        boolean result = false;
        for (Class<?> intrerface : interfaces) {
            if (intrerface == List.class) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static boolean isClassStaticPrivate(Class<?> clazz) {
        return clazz.getModifiers() == (Modifier.PRIVATE | Modifier.STATIC);
    }

    private static boolean isIndexOutOfBoundsException(Class<?> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        try {
            Method method = clazz.getDeclaredMethod("get", int.class);
            method.setAccessible(true);
            Constructor constructor = clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            Object o = constructor.newInstance();
            method.invoke(o, 5);
        } catch (NoSuchMethodException e) {
            return false;
        } catch (InvocationTargetException e) {
            if (e.getCause().toString().contains("IndexOutOfBoundsException")) {
                return true;
            }
        }
        return false;
    }

    public static Class getExpectedClass() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?>[] classes = Class.forName("java.util.Collections").getDeclaredClasses();
        for (Class<?> clazz : classes) {
            if (isClassStaticPrivate(clazz)) {
                if (isExtendListInterface(clazz.getInterfaces()) ||
                        (isExtendListInterface(clazz.getSuperclass().getInterfaces()))) {
                    if (isIndexOutOfBoundsException(clazz))
                        return clazz;
                }
            }
        }
        return null;
    }
}
