package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();

        FileInputStream fileInputStream = new FileInputStream(fileName1);
        byte[] buffer = new byte[fileInputStream.available()];
        fileInputStream.read(buffer);
        fileInputStream.close();

        FileInputStream fileInputStream1 = new FileInputStream(fileName2);
        byte[] buffer1 = new byte[fileInputStream1.available()];
        fileInputStream1.read(buffer1);
        fileInputStream1.close();

        byte[] result = new byte[buffer.length + buffer1.length];
        System.arraycopy(buffer1, 0, result, 0, buffer1.length);
        System.arraycopy(buffer, 0, result, buffer1.length, buffer.length);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName1);
        fileOutputStream.write(result);
        fileOutputStream.close();

    }
}
