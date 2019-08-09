package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    private static ArrayList<String> strings;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        strings = new ArrayList<String>();

        ArrayList<String> listMax = new ArrayList<String>();

        for (int i = 0; i < 5; i++) strings.add(bufferedReader.readLine());

        int maxLength = strings.get(0).length();

        for (int i = 1; i < strings.size(); i++) {
            if (maxLength < strings.get(i).length())
                maxLength = strings.get(i).length();
        }
        for (int i = 0; i < strings.size(); i++) {
            if (strings.get(i).length() == maxLength)
                listMax.add(strings.get(i));
        }

        for (int i = 0; i < listMax.size(); i++) {
            System.out.println(listMax.get(i));
        }


    }
}
