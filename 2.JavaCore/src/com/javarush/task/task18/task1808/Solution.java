package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(bufferedReader.readLine());
        FileOutputStream outputStream1 = new FileOutputStream(bufferedReader.readLine());
        FileOutputStream outputStream2 = new FileOutputStream(bufferedReader.readLine());

        bufferedReader.close();
        byte[] b = new byte[inputStream.available()];
        inputStream.read(b);
        inputStream.close();

        if (b.length % 2 == 0){
            for (int i = 0; i < b.length / 2; i++) {
                outputStream1.write(b[i]);
            }
            for (int i = b.length / 2; i < b.length; i++) {
                outputStream2.write(b[i]);
            }
        } else
        {
            for (int i = 0; i < b.length / 2 + 1; i++) {
                outputStream1.write(b[i]);
            }
            for (int i = b.length / 2 + 1; i < b.length; i++) {
                outputStream2.write(b[i]);
            }
        }

        outputStream1.close();
        outputStream2.close();
    }
}
