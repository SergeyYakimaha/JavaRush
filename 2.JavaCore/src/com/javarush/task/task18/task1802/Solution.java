package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileInputStream = new FileInputStream(bufferedReader.readLine());

        int min = Integer.MAX_VALUE;

        while (fileInputStream.available() > 0){
            int b = fileInputStream.read();
            if (b < min) min = b;
        }

        bufferedReader.close();
        fileInputStream.close();

        System.out.println(min);

    }
}
