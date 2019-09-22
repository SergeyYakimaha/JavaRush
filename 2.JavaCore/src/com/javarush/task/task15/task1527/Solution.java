package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String text = bufferedReader.readLine();
        bufferedReader.close();

        String[] stringParams = text.substring(text.indexOf("?") + 1).split("&");

        for (int i = 0; i < stringParams.length; i++) {
            String [] params = stringParams[i].split("\\s");


            }
        }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
