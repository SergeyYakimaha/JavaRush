package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        String[] splited = string.trim().split("\\s+");
        ArrayList<String> firstUpperString = new ArrayList<String>();

        for (String s: splited) {
            firstUpperString.add(s.substring(0, 1).toUpperCase() + s.substring(1));
        }

        String result = "";

        for (String s: firstUpperString) {
            result = result + s + " ";
        }
        System.out.println(result.trim());
    }
}
