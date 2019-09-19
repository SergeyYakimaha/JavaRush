package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    private Map<Integer, String> mapFiles = new TreeMap<>();
    private String outputFileName = "";

    private void addFileName(String fileName){
        char[] arrayChars = fileName.toCharArray();
        String partNumber = "";
        for (int i = arrayChars.length - 1; i > 0 ; i--) {
            if (Character.isDigit(arrayChars[i]))
                partNumber = arrayChars[i] + partNumber;
            else
            {
                if (outputFileName.isEmpty())
                    outputFileName = fileName.substring(0, i - 4);
                break;
            }
        }
        mapFiles.put(Integer.parseInt(partNumber), fileName);
    }

    private void writeFile() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(outputFileName, true);

        for(Map.Entry<Integer, String> entry: mapFiles.entrySet()) {
            FileInputStream fileInputStream = new FileInputStream(entry.getValue());

            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            fileInputStream.close();
            fileOutputStream.write(buffer);
        }
        fileOutputStream.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        Solution FilesApp = new Solution();

        while (!(fileName = bufferedReader.readLine()).equals("end")){
            FilesApp.addFileName(fileName);
        }
        FilesApp.writeFile();
        bufferedReader.close();
    }
}
