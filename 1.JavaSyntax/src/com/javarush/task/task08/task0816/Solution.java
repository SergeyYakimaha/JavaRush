package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static Map<String, Date> createMap() throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        Map<String, Date> map = new HashMap<>();

        map.put("Сталлоне", dateFormat.parse("MAY 1 2012"));
        map.put("Ленин", dateFormat.parse("MAY 1 2012"));
        map.put("Серега", dateFormat.parse("MAY 1 2012"));
        map.put("Вася", dateFormat.parse("MAY 1 2012"));
        map.put("Петя", dateFormat.parse("MAY 1 2012"));
        map.put("Игорь", dateFormat.parse("MAY 1 2012"));
        map.put("Маша", dateFormat.parse("MAY 1 2012"));
        map.put("Аня", dateFormat.parse("MAY 1 2012"));
        map.put("Таня", dateFormat.parse("MAY 1 2012"));
        map.put("Катя", dateFormat.parse("MAY 1 2012"));

       return map;

    }

    public static void removeAllSummerPeople(Map<String, Date> map) {

        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()){

            int month = iterator.next().getValue().getMonth();

            if (month >=  5 && month <= 7)
                iterator.remove();
        }

    }

    public static void main(String[] args) throws ParseException {
        Map<String, Date> map = createMap();

        removeAllSummerPeople(map);
        }
}
