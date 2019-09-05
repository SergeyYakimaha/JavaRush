package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputValue;
        while (!(inputValue = bufferedReader.readLine()).equals("exit")) {
            try {
                if (inputValue.contains(".")) {
                    print(Double.parseDouble(inputValue));
                } else if (Integer.parseInt(inputValue) <= 0 | Integer.parseInt(inputValue) >= 128) {
                    print(Integer.parseInt(inputValue));
                } else if (Short.parseShort(inputValue) > 0 & Short.parseShort(inputValue) < 128) {
                    print(Short.parseShort(inputValue));
                }
            } catch (NumberFormatException e) {
                print(inputValue);
            }
        }

    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
