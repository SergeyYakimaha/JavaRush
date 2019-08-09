package com.javarush.task.task04.task0428;

/* 
Положительное число
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());
        int c = Integer.parseInt(bufferedReader.readLine());

        int count = 0;

        if (a > 0)
            count++;
        if (b > 0)
            count++;
        if (c > 0)
            count++;

        System.out.println(count);

    }
}
