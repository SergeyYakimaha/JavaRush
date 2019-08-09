package com.javarush.task.task08.task0812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        List<Integer> list = new ArrayList<Integer>();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
            list.add(Integer.parseInt(bufferedReader.readLine()));
        }

        int number = list.get(0);

        int  maxrepeat = 1;
        int repeat = 1;

        for (int i = 1; i < list.size(); i++) {
            if (number == list.get(i))
            {
                repeat++;
                number = list.get(i);
            }
            else
                {
                    if (repeat > maxrepeat)
                        maxrepeat = repeat;
                    repeat = 1;
                    number = list.get(i);
                }
        }

        if (maxrepeat < repeat)
            maxrepeat = repeat;

        System.out.println(maxrepeat);

    }
}