package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static int max(int a, int b){
        if (a >= b)
            return a;
        else
            return b;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());
        int c = Integer.parseInt(bufferedReader.readLine());

        int m;

        m = max(a, b);
        m = max(m, c);


        if (m == a)
        {
            m = max(b, c);
            if (m == b)
                System.out.println(a + " " + b + " " + c);
            else
                System.out.println(a + " " + c + " " + b);
        }
        else
            if (m == b)
            {
                m = max(a, c);
                if (m == a)
                    System.out.println(b + " " + a + " " + c);
                else
                    System.out.println(b + " " + c + " " + a);
            }
            else
            {
                if (m == c)
                {
                    m = max(a, b);
                    if (m == a)
                        System.out.println(c + " " + a + " " + b);
                    else
                        System.out.println(c + " " + b + " " + a);
                }
            }




    }
}
