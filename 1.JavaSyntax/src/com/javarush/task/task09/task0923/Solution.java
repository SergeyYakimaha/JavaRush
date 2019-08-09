package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();

        String vowelString = "";
        String consonantString = "";

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != ' ') {
                if (isVowel(string.charAt(i)))
                    vowelString = vowelString + string.charAt(i) + " ";
                else
                    consonantString = consonantString + string.charAt(i) + " ";
            }
        }

        System.out.println(vowelString);
        System.out.println(consonantString);
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам
        for (char d : vowels) {  // ищем среди массива гласных
            if (c == d) {
                return true;
            }
        }
        return false;
    }
}