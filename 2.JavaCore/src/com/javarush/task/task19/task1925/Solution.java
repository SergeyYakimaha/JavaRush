package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1 = args[0];
        String fileName2 = args[1];

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName2));

        String line;
        String resultLine = "";
        while ((line = bufferedReader.readLine()) != null){
            String[] strings = line.split("\\s");
            for (int i = 0; i < strings.length; i++) {
                if (strings[i].length() > 6)
                    resultLine = resultLine + strings[i] + ",";
            }
        }
        bufferedWriter.write(resultLine.substring(0, resultLine.length() - 1));

        bufferedReader.close();
        bufferedWriter.close();
    }
}
