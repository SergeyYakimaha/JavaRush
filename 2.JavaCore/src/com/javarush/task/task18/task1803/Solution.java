package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(bufferedReader.readLine());

        List<Integer> blist = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        while (inputStream.available() > 0) {
            blist.add(inputStream.read());
        }

        for (int i = 0; i < blist.size(); i++) {
            map.put(blist.get(i), Collections.frequency(blist, blist.get(i)));
        }

        int max = Collections.max(map.values());

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() == max) {
                System.out.print(pair.getKey() + " ");
            }
        }
    }
}
