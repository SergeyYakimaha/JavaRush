package com.javarush.task.task19.task1906;

/* 
Четные символы
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

        int countCh = 0;
        int ch;

        while ((ch = bufferedReader.read()) != -1){
            if (++countCh % 2 == 0)
                bufferedWriter.write(ch);
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
