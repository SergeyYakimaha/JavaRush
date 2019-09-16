package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;/*
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(bufferedReader.readLine());

        bufferedReader.close();

        List<Integer> blist = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        while (inputStream.available() > 0) {
            blist.add(inputStream.read());
        }

        inputStream.close();

        for (int i = 0; i < blist.size(); i++) {
            map.put(blist.get(i), Collections.frequency(blist, blist.get(i)));
        }

        int max = Collections.min(map.values());

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            if (pair.getValue() == max) {
                System.out.print(pair.getKey() + " ");
            }
        }

    }
}
