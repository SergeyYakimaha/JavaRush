package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        Map<String, String> map = new HashMap<>();

        map.put("Иванов", "Коля");
        map.put("Иванов", "Сергей");
        map.put("Петров", "Иван");
        map.put("Иванов", "Сергей");
        map.put("Иванов", "Петя");
        map.put("Иванов", "Сергей");
        map.put("Сидоров", "Сергей");
        map.put("Иванов", "Сергей");
        map.put("Иванов", "Миша");
        map.put("Васин", "Сергей");

        return map;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
