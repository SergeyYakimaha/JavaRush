package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        //FileInputStream fileInputStream = new FileInputStream("c:\\1.txt");
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();

        while (fileInputStream.available() > 0) {
            int ascii = (char) fileInputStream.read();
            map.put(ascii, map.getOrDefault(ascii, 0) + 1);
        }

        fileInputStream.close();

        for (Map.Entry entry: map.entrySet()) {
            System.out.println((char)(int)entry.getKey() + " " + entry.getValue().toString());

        }
    }
}
