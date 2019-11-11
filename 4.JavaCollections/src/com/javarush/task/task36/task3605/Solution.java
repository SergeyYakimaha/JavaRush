package com.javarush.task.task36.task3605;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeSet;

/* 
Использование TreeSet
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        TreeSet<String> treeSet = new TreeSet<>();

        //BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\CrUD.txt"));
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        String line;
        String regex = "[a-z]";
        while ((line = bufferedReader.readLine()) != null) {
            for (int i = 0; i < line.length(); i++) {
                String s = Character.toString(line.charAt(i)).toLowerCase();
                if (s.matches(regex)) {
                    treeSet.add(s);
                }
            }
        }
        int i = 0;
        for (String s : treeSet) {
            if (i <= 4) {
                System.out.print(s);
                i++;
            }
        }
    }
}
