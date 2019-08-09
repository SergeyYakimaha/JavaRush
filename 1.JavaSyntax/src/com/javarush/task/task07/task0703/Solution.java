package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] list_s = new String[10];
        int[] list_i = new int[10];

        for (int i = 0; i < list_s.length; i++) {
            list_s[i] = bufferedReader.readLine();
        }

        for (int i = 0; i < list_i.length; i++) {
            list_i[i] = list_s[i].length();
            System.out.println(list_i[i]);
        }
    }
}
