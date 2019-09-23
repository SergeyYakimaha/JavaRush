package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();
    private String fileName;

    public Solution() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        fileName = bufferedReader.readLine();
        bufferedReader.close();
    }

    private void main() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        String line;
        while ((line = bufferedReader.readLine()) != null){
            String[] arrayString = line.split("\\s");
            int count = 0;

            for (int i = 0; i < arrayString.length; i++) {
                for (int j = 0; j < words.size(); j++) {
                    if (arrayString[i].equals(words.get(j)))
                        count++;
                }
            }
            if (count == 2)
                System.out.println(line);
        }
        bufferedReader.close();
    }

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        Solution app = new Solution();
        app.main();
    }
}
