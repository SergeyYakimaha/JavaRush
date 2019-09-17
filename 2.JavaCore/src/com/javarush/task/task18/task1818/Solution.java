package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String filename1 = bufferedReader.readLine();

        FileOutputStream fileOutputStream1 = new FileOutputStream(filename1);
        FileInputStream fileInputStream2 = new FileInputStream(bufferedReader.readLine());
        FileInputStream fileInputStream3 = new FileInputStream(bufferedReader.readLine());

        bufferedReader.close();

        byte[] buffer = new byte[fileInputStream2.available()];
        fileInputStream2.read(buffer);
        fileOutputStream1.write(buffer);

        fileInputStream2.close();
        fileOutputStream1.close();

        fileOutputStream1 = new FileOutputStream(filename1, true);
        buffer = new byte[fileInputStream3.available()];
        fileInputStream3.read(buffer);
        fileOutputStream1.write(buffer);

        fileOutputStream1.close();
        fileInputStream3.close();


    }
}
