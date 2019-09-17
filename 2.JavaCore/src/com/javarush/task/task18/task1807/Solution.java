package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(bufferedReader.readLine());

        bufferedReader.close();

        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);

        inputStream.close();

        int countChar = 0;

        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] == 44) countChar++;
        }

        System.out.println(countChar);

    }
}
