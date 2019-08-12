package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = bufferedReader.readLine();
        File file = new File(fileName);

        FileWriter fileReader = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileReader);

        while (true) {
            String line = bufferedReader.readLine();
            bufferedWriter.write(line + "\n");
            if (line.equals("exit")) {break;}
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
