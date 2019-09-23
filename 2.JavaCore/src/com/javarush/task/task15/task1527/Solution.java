package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String text = bufferedReader.readLine();
        bufferedReader.close();

        String[] stringParams = text.substring(text.indexOf("?") + 1).split("&");
        String strOut = "";

        for (int i = 0; i < stringParams.length; i++) {
            strOut = strOut + stringParams[i].split("=")[0] + " ";
        }

        System.out.println(strOut.trim());

        for (int i = 0; i < stringParams.length; i++) {
            String[] params = stringParams[i].split("=");
            if (params[0].equals("obj")) {
                try {
                    alert(Double.parseDouble(params[1]));
                } catch (NumberFormatException e) {
                    alert(params[1]);
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
