package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    private String fileName;

    public Solution() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        this.fileName = bufferedReader.readLine();
        bufferedReader.close();
    }

    private String addSpaces(String value, int spaceCount) {
        for (int i = value.length(); i < spaceCount; i++) {
            value = value + " ";
        }
        return value;
    }

    private void addOrder(String productName, String price, String quantity) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fileName, true), "windows-1251"));

        productName = addSpaces(productName, 30);
        price = addSpaces(price, 8);
        quantity = addSpaces(quantity, 4);
        String id = addSpaces(nextID(), 8);

        if (Integer.parseInt(id.trim()) > 1)
            bufferedWriter.newLine();

        bufferedWriter.write(id + productName + price + quantity, 0, (id + productName + price + quantity).length());

        bufferedWriter.close();
    }

    private String nextID() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line = null;
        int maxID = 0;
        {
            while ((line = bufferedReader.readLine()) != null) {
                int id = Integer.parseInt(line.substring(0, 8).trim());
                if (maxID < id)
                    maxID = id;
            }
        }
        bufferedReader.close();
        return String.valueOf(++maxID);
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 0 && args[0] == "-c") {
                Solution CrUD = new Solution();
                CrUD.addOrder(args[1], args[2], args[3]);
//        CrUD.addOrder("Шорты пляжные синие", "159.00", "12");
//        CrUD.addOrder("Шорты синие", "159.00", "2");
//        CrUD.addOrder("Шорты пляжные", "170.00", "15");
//        CrUD.addOrder("Шорты пляжные синие", "20", "12");
            }
    }
}
