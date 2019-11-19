package com.javarush.task.task37.task3703;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/*
Найти класс по описанию
*/
public class Solution {
    public static void main(String[] args) {
        ConcurrentSkipListMap<Integer, String> listMap = new ConcurrentSkipListMap<>();

        listMap.put(1, "one");
        listMap.put(2, "two");
        listMap.put(3, "three");
        listMap.put(4, "four");
        listMap.put(5, "five");
        listMap.put(-1, "-one");


        Map<Integer, String> map = listMap.tailMap(3);
        Map<Integer, String> map1 = listMap.headMap(3);


        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        return ConcurrentSkipListMap.class;
    }
}
