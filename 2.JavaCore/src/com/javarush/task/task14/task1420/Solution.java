package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int a = 0, b = 0;
        int max = 1;
        int divMax = 1;

        a = Integer.parseInt(bufferedReader.readLine());
        b = Integer.parseInt(bufferedReader.readLine());

        if (a <= 0 || b <= 0) {
            throw new Exception();
        }

        max = a < b ? a : b;

        for (int i = 2; i <= max; i++) {
            if (a % i == 0 && b % i == 0) {
                divMax = i;
            }
        }

        System.out.println(divMax);
    }
}
