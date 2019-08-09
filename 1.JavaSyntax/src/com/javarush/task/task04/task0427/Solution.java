package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bufferedReader.readLine());
        int dcount = 0;

        if (a >= 1 & a <= 999) {

            if (a <= 9)
                dcount = 1;
            else if (a >= 10 & a < 100)
                dcount = 2;
            else
                dcount = 3;

            if (dcount == 1)
                if (a % 2 == 0)
                    System.out.println("четное однозначное число");
                else
                    System.out.println("нечетное однозначное число");

            if (dcount == 2)
                if (a % 2 == 0)
                    System.out.println("четное двузначное число");
                else
                    System.out.println("нечетное двузначное число");

            if (dcount == 3)
                if (a % 2 == 0)
                    System.out.println("четное трехзначное число");
                else
                    System.out.println("нечетное трехзначное число");
        }



    }
}
