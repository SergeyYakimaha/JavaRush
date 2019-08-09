package com.javarush.task.task10.task1012;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Количество букв
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Алфавит
        List<Character> alphabet = Arrays.asList(
                'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж',
                'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о',
                'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц',
                'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я');

        // Ввод строк
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (String string : list) {
            for (int i = 0; i < string.length(); i++) {
                char ch = string.charAt(i);
                map.putIfAbsent(ch, 0);
                map.put(ch, map.get(ch) + 1);
            }
        }

        for (Character ch : alphabet){
            if (map.containsKey(ch)){
                System.out.println(ch + " " + map.get(ch));
            }
            else {
                System.out.println(ch + " " + 0);
            }
        }
    }
}
