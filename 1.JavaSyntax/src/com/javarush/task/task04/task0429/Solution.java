package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());
        int c = Integer.parseInt(bufferedReader.readLine());

        int count_plus = 0;
        int count_minus = 0;

        if (a < 0)
            count_minus++;
        else
            if (a > 0)
                count_plus++;

        if (b < 0)
            count_minus++;
        else
        if (b > 0)
            count_plus++;

        if (c < 0)
            count_minus++;
        else
        if (c > 0)
            count_plus++;

        System.out.println("количество отрицательных чисел: " + count_minus);
        System.out.println("количество положительных чисел: " + count_plus);




    }
}
