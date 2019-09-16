package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();

//        fileName1 = "C:\\JavaRushData\\allLines.txt";
//        fileName2 = "C:\\JavaRushData\\forRemoveLines.txt";

        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName1)));

        while (reader.ready()) {
            allLines.add(reader.readLine());
        }
        reader.close();

        reader = new BufferedReader(new FileReader(new File(fileName2)));
        while (reader.ready()) {
            forRemoveLines.add(reader.readLine());
        }
        reader.close();

        new Solution().joinData();

    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
