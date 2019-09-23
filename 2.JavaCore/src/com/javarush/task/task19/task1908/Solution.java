package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;

public class Solution {
    private String fileName1;
    private String fileName2;

    public Solution() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.fileName1 = bufferedReader.readLine();
        this.fileName2 = bufferedReader.readLine();
        bufferedReader.close();
    }

    private void WriteNumbers() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));

        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String[] buffer  = line.split("\\s");

            for (int i = 0; i < buffer.length; i++) {
                try {
                    String writeString = Integer.toString(Integer.parseInt(buffer[i]));
                    bufferedWriter.write(writeString + " ");
                } catch (NumberFormatException e) {
                }
            }
        }

        bufferedReader.close();
        bufferedWriter.close();
    }


    public static void main(String[] args) throws IOException {
        Solution app = new Solution();
        app.WriteNumbers();
    }
}
