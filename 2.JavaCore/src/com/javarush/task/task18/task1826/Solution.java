package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    private void encode(String fileName, String fileOutputName) throws IOException {
        FileInputStream inputStream = new FileInputStream(fileName);
        FileOutputStream outputStream = new FileOutputStream(fileOutputName);

        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        inputStream.close();
        for (int i = 0; i < buffer.length; i++) {
            buffer[i]++;
        }
        outputStream.write(buffer);
        outputStream.close();
    }

    private void decode(String fileName, String fileOutputName) throws IOException {
        FileInputStream inputStream = new FileInputStream(fileName);
        FileOutputStream outputStream = new FileOutputStream(fileOutputName);

        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        inputStream.close();
        for (int i = 0; i < buffer.length; i++) {
            buffer[i]--;
        }
        outputStream.write(buffer);
        outputStream.close();
    }

    public static void main(String[] args) throws IOException {
        Solution decoder = new Solution();
        switch (args[0]) {
            case "-e":
                decoder.encode(args[1], args[2]);
                break;
            case "-d":
                decoder.decode(args[1], args[2]);
                break;
        }
    }

}
