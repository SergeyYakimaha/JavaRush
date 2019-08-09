package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        ArrayList<String>[] listArrStr = new ArrayList[3];

        for (int i = 0; i < 3; i++) {
            ArrayList<String> strings = new ArrayList<String>();
            strings.add(Integer.valueOf(i).toString());
            strings.add(Integer.valueOf(i + 1).toString());
            strings.add(Integer.valueOf(i + 2).toString());
            listArrStr[i] = strings;
        }
        return listArrStr;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}