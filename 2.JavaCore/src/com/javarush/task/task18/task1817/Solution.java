package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException, IOException {
        this.fileName = fileName;
    }

    private double numberOf() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        String line;
        int countAllSymbol = 0;
        int countSpaces = 0;

        while ((line = bufferedReader.readLine()) != null){
            countAllSymbol = countAllSymbol + line.length();
            countSpaces = countSpaces + (line.length() - line.replaceAll(" ", "").length());
        }

        bufferedReader.close();

        return (double)countSpaces/countAllSymbol * 100;
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 0) {
            Solution counter = new Solution(args[0]);
            System.out.println(String.format("%.2f",counter.numberOf()));
        }
    }
}
