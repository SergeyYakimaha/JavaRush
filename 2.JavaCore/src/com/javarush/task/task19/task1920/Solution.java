package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Map<String, Double> map = new HashMap<String, Double>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));

        String line;
        while ((line = bufferedReader.readLine()) != null) {

            String key = line.split("\\s")[0];
            Double value = Double.parseDouble(line.split("\\s")[1]);

            map.put(key, map.getOrDefault(key, 0.0) + value);
        }

        bufferedReader.close();

        double max = Collections.max(map.values());
        List<String> list = new ArrayList<>();

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getValue() == (max))
                list.add(entry.getKey());
        }

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }
}
