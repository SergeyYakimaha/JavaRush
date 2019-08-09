package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {

    public static double convertEurToUsd(int eur, double course) {
        return eur * course;
    }

    public static void main(String[] args) {
        System.out.println(convertEurToUsd(10, 1.55));
        System.out.println(convertEurToUsd(50, 5.36));

    }
}
