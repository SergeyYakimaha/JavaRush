package com.javarush.task.task13.task1322;

/* 
Интерфейс SimpleObject
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        SimpleObject<String> stringObject = new StringObject<Object>();
        SimpleObject<Integer> integerObject = new IntegerObject<Object>();

        System.out.println(stringObject.getInstance().toString());
        System.out.println(integerObject.getInstance().toString());
    }

    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }


    static class StringObject<Object> implements SimpleObject<String> {
        @Override
        public SimpleObject<String> getInstance() {
            return this;
        }
    }

    static class IntegerObject<Object> implements SimpleObject<Integer> {
        @Override
        public SimpleObject<Integer> getInstance() {
            return this;
        }
    }

}
