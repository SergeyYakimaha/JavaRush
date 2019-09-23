package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        Map<String, Double> map = new TreeMap<>();

        String line;
        while ((line = bufferedReader.readLine()) != null){
            String[] strings = line.split("\\s");
            map.put(strings[0], map.getOrDefault(strings[0],0.0) + Double.parseDouble(strings[1]));
            // или так (читается легче)
//          String key = strings[0];
//          Double value = Double.parseDouble(strings[1]);
//          map.put(key, map.getOrDefault(key,0.0) + value);
        }

        for(Map.Entry<String, Double> entry: map.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());

        bufferedReader.close();
    }
}
