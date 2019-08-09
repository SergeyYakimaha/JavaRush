package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(bufferedReader.readLine());

        int i = 0;
        int a = 0;

        do {
            i = number / 10;
            double i1 = ((double)number / 10);
            a = (int)((i1 -  (double)i) * (double)10);
            if (a % 2 == 0)
                odd++;
            else
                even++;
            number = i;
        } while (i > 0);
    }
}
