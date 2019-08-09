package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static Map<String, Integer> createMap() {
        Map<String, Integer> map = new HashMap<String, Integer>();

        map.put("Вася", 200);
        map.put("Гена", 600);
        map.put("Маша", 100);
        map.put("Петя", 700);
        map.put("Боря", 888);
        map.put("Кирилл", 400);
        map.put("Сережа", 300);
        map.put("Вова", 500);
        map.put("Коля", 100);
        map.put("Игорь", 9999);

        return map;
    }

    public static void removeItemFromMap(Map<String, Integer> map) {

        Iterator<Integer> iterator = map.values().iterator();

        while (iterator.hasNext())
        {
            if (iterator.next() < 500)
                iterator.remove();
        }
    }

    public static void main(String[] args) {
        Map<String, Integer> map = createMap();

        removeItemFromMap(map);

    }
}