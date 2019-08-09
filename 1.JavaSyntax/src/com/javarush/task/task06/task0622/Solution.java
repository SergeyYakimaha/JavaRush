package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] list = new int[5];

        for (int i = 0; i < 5; i++) {
            list[i] = Integer.parseInt(reader.readLine());
        }

        int temp;

        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - i - 1; j++) {
                if (list[j] > list[j + 1]) {
                    // меняем элементы местами
                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }
}
