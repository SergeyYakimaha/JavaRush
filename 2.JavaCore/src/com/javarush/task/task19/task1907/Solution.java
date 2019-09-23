package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();

        BufferedReader bufferedFileReader = new BufferedReader(new FileReader(fileName));
        String line;
        int wordCount = 0;

        while ((line = bufferedFileReader.readLine()) != null){
            String[] buffer = line.split("\\W");
            for (int i = 0; i < buffer.length; i++) {
                if (buffer[i].equals("world"))
                    wordCount++;
            }
        }
        bufferedFileReader.close();
        System.out.println(wordCount);
    }
}
