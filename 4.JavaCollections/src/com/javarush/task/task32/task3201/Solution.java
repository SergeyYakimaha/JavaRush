package com.javarush.task.task32.task3201;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(args[0], "rw");

        if (randomAccessFile.length() < Integer.parseInt(args[1]) + args[2].length()) {
            long oldFileLength = randomAccessFile.length();
            randomAccessFile.setLength(oldFileLength + args[2].length());
            randomAccessFile.seek(oldFileLength);
        } else {
            randomAccessFile.seek(Integer.parseInt(args[1]));
        }
        randomAccessFile.write(args[2].getBytes());
        randomAccessFile.close();

    }
}
