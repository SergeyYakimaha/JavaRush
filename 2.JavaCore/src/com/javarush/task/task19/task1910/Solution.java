package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();

        bufferedReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            bufferedWriter.write(line.replaceAll("\\p{Punct}", ""));
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
