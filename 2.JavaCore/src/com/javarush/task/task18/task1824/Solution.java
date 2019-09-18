package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String fileNames = br.readLine();
            try (FileInputStream inputStream = new FileInputStream(fileNames)) {
            } catch (FileNotFoundException e) {
                System.out.println(fileNames);
                break;
            }
        }
    }
}
