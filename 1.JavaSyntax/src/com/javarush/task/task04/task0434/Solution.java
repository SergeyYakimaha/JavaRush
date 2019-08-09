package com.javarush.task.task04.task0434;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        int i = 1;
        int a = 0;

        while (i <= 10){

            int j = 1;
            String s = "";

            while (j <= 10) {
                a = i * j;
                s = s + a + " ";
                j++;
            }

            System.out.println(s);
            i++;
        }

    }
}
