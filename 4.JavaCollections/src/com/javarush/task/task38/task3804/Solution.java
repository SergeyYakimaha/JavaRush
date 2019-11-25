package com.javarush.task.task38.task3804;

/* 
Фабрика исключений
*/

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Solution {
    public static Class getFactoryClass() {
        return ExceptionFactory.class;
    }

    public static class ExceptionFactory {

        public static Throwable createExceptionFactory(Enum type) {

            if (type != null) {

                String message = type.name().charAt(0) + type.name().substring(1).toLowerCase().replace("_", " ");

                if (type instanceof ApplicationExceptionMessage) {
                    return new Exception(message);
                }

                if (type instanceof DatabaseExceptionMessage) {
                    return new RuntimeException(message);
                }

                if (type instanceof UserExceptionMessage) {
                    return new Error(message);
                }
            }
            return new IllegalArgumentException();
        }
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class<?>[] paramTypes;
        Object[] argsMethod;

        paramTypes = new Class[]{Enum.class};
        Method method = Solution.getFactoryClass().getMethod("createExceptionFactory", paramTypes);

        argsMethod = new Object[]{ApplicationExceptionMessage.SOCKET_IS_CLOSED};
        System.out.println(method.invoke(ExceptionFactory.class, argsMethod));

        argsMethod = new Object[]{DatabaseExceptionMessage.NOT_ENOUGH_CONNECTIONS};
        System.out.println(method.invoke(ExceptionFactory.class, argsMethod));

        Throwable throwable = ExceptionFactory.createExceptionFactory(ApplicationExceptionMessage.SOCKET_IS_CLOSED);
        System.out.println(throwable.toString());
    }
}