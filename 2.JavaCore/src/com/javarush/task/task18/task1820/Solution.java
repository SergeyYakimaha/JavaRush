package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;

public class Solution {
    private String inputFileName;
    private String outputFileName;

    private void work() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFileName));
        BufferedWriter bufferedWriter = new BufferedWriter((new FileWriter(outputFileName)));
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String[] stringNumbers = line.split("\\s");

            for (int i = 0; i < stringNumbers.length; i++) {
                String intString = String.valueOf(Math.round(Float.parseFloat(stringNumbers[i])));
                bufferedWriter.write(((i == stringNumbers.length - 1) ? intString : intString + " "));
            }

            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }

    public Solution() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        this.inputFileName = bufferedReader.readLine();
        this.outputFileName = bufferedReader.readLine();

        bufferedReader.close();
    }

    public static void main(String[] args) throws IOException {
        new Solution().work();
    }
}
