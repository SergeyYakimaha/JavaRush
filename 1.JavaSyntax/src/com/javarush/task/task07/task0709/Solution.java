package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> listMin = new ArrayList<String>();

        for (int i = 0; i < 5; i++) {
            list.add(bufferedReader.readLine());
        }

        int minLenght = list.get(0).length();

        for (int i = 1; i < list.size(); i++) {
            if (minLenght > list.get(i).length())
                minLenght = list.get(i).length();
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == minLenght)
                listMin.add(list.get(i));
        }

        for (int i = 0; i < listMin.size(); i++) {
            System.out.println(listMin.get(i));
        }
    }
}
