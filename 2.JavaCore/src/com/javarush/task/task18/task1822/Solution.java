package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    private String fileName;

    public Solution() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.fileName = bufferedReader.readLine();
        bufferedReader.close();
    }

    private String getOrderInfo(String id) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(fileName)));

        String line;

        while ((line = bufferedReader.readLine()) != null)
        {
            String[] words = line.split("\\s");
            if (words[0].equals(id))
                break;
        }
        bufferedReader.close();
        return line;
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 0) {
            Solution order = new Solution();
            System.out.println(order.getOrderInfo(args[0]));
        }
    }
}
