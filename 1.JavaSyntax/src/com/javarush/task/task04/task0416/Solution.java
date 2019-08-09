package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        double number = Double.parseDouble(bufferedReader.readLine());

        double r = number % 5;

        if (r >= 0 & r < 3)
            System.out.println("зелёный");
        else if (r >= 3 & r < 4)
            System.out.println("жёлтый");
        else if (r >= 4 & r < 5)
            System.out.println("красный");

    }
}