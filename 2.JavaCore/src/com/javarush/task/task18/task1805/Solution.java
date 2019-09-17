package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(bufferedReader.readLine());

        bufferedReader.close();

        List<Integer> lint = new ArrayList<>();
        Set<Integer> sint = new HashSet<>();

        while (inputStream.available() > 0){
            sint.add(inputStream.read());
        }

        inputStream.close();

        lint = new ArrayList<Integer>(sint);

        Collections.sort(lint);

        for (int i = 0; i < lint.size(); i++) {
            System.out.printf(lint.get(i) + " ");
        }

    }
}
