package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < 5; i++) {
            list.add(bufferedReader.readLine());
        }

        for (int i = 0; i < 13; i++) {
            String lastStr = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            list.add(0, lastStr);
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
