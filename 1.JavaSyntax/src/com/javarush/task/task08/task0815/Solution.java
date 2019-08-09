package com.javarush.task.task08.task0815;

import java.util.HashMap;
import java.util.Map;

/* 
Перепись населения
*/

public class Solution {
    public static Map<String, String> createMap() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("Иванов", "Сергей");
        map.put("Петров", "Сергей");
        map.put("Сидоров", "Иван");
        map.put("Иван34ов", "Серrгей");
        map.put("Пет66ров", "Сергей");
        map.put("Сид55оров", "Иван");
        map.put("Ив44анов", "Сеrргей");
        map.put("Пе33тров", "Сергей");
        map.put("Сид22оров", "Ивeан");
        map.put("11", "Иван");
        return map;
    }

    public static int getCountTheSameFirstName(Map<String, String> map, String name) {
        int result = 0;
        for (Map.Entry<String, String> pair: map.entrySet()) {
            if (pair.getValue().equals(name)) result++;
        }
        return result;
    }

    public static int getCountTheSameLastName(Map<String, String> map, String lastName) {
        int result = 0;
        for (Map.Entry<String, String> pair: map.entrySet()) {
            if (pair.getKey().equals(lastName)) result++;
        }
        return result;
    }

    public static void main(String[] args) {
//        Map<String, String> map = createMap();
//        System.out.println(getCountTheSameFirstName(map, "Сергей"));
    }
}
