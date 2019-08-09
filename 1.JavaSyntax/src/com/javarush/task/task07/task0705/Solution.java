package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[] arr1 = new int[20];
        int[] arr2 = new int[10];
        int[] arr3 = new int[10];

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = Integer.parseInt(bufferedReader.readLine());
        }

        for (int i = 0; i < arr1.length - 10; i++) {
            arr2[i] = arr1[i];
        }

        for (int i = 10; i < arr1.length; i++) {
            arr3[i - 10] = arr1[i];
        }

        for (int i = 0; i < arr3.length; i++) {
            System.out.println(arr3[i]);
        }
    }
}
