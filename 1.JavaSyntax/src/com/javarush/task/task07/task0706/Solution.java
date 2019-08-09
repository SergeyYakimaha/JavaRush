package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] list = new int[15];

        int even = 0;
        int odd = 0;


        for (int i = 0; i < list.length; i++) {
            list[i] = Integer.parseInt(bufferedReader.readLine());
        }

        for (int i = 0; i < list.length; i++) {
            if (i % 2 == 0)
                even += list[i];
            else
                odd += list[i];
        }

        String result = (even > odd) ? "В домах с четными номерами проживает больше жителей." : "В домах с нечетными номерами проживает больше жителей.";

        System.out.println(result);
    }
}
