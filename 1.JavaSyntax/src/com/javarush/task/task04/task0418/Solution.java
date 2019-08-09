package com.javarush.task.task04.task0418;

/* 
Минимум двух чисел
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());

        if (a < b)
            System.out.println(a);
        else
            if (b < a)
                System.out.println(b);
            else
                System.out.println(a);

    }
}