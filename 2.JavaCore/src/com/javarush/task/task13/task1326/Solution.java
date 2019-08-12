package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = bufferedReader.readLine();

        FileInputStream fileInputStream = new FileInputStream(fileName);

        ArrayList<Integer> list = new ArrayList<>();

        String string = "";

        while (fileInputStream.available() > 0) {
            char ch = (char) fileInputStream.read();
            if (ch == '\n' | ch == '\r') {
                int number = Integer.parseInt(string);
                if (number % 2 == 0) {
                    list.add(number);
                }
                string = "";
            } else
                string = string + ch;
        }

        Collections.sort(list);

        for (Integer part : list) {
            System.out.println(part.toString());
        }

        fileInputStream.close();
    }
}
