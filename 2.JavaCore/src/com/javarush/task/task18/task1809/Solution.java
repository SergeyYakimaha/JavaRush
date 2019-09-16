package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream inputStream = new FileInputStream(bufferedReader.readLine());
        //FileInputStream inputStream = new FileInputStream("C:\\JavaRushData\\inputFile.txt");
        FileOutputStream outputStream = new FileOutputStream(bufferedReader.readLine());
        //FileOutputStream outputStream = new FileOutputStream("C:\\JavaRushData\\ouputFile.txt");

        List<Byte> intStream = new ArrayList();

        byte[] buffer = new byte[1000];
        while (inputStream.available() > 0){
            int count = inputStream.read(buffer);
            for (int i = 0; i < count; i++) {
                intStream.add(buffer[i]);
            }
        }

        for (int i = intStream.size() - 1; i >= 0 ; i--) {
            outputStream.write(intStream.get(i));
        }

        inputStream.close();
        outputStream.close();
    }
}
