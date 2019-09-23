package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1 = args[0];
        String fileName2 = args[1];

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));

        String line;
        while ((line = bufferedReader.readLine()) != null){
            String[] strings = line.split("\\s");
            for (int i = 0; i < strings.length; i++) {
                if (strings[i].matches(".*[0-9]+.*")){
                        bufferedWriter.write(strings[i] + " ");
                }
            }
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
