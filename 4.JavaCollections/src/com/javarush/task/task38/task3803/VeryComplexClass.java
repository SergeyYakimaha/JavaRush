package com.javarush.task.task38.task3803;

/* 
Runtime исключения (unchecked exception)
*/

import java.util.List;

public class VeryComplexClass {
    public void methodThrowsClassCastException() {
        Object string = "aaa";
        int i = 10 - (Integer)string;
    }

    public void methodThrowsNullPointerException() {
        List<Integer> list = null;
        list.get(6);
    }

    public static void main(String[] args) {

    }
}
