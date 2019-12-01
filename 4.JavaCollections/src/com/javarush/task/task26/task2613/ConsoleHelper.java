package com.javarush.task.task26.task2613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String result = null;
        try {
            result = bis.readLine();
        } catch (IOException e) {
        }
        return result;
    }

    public static String askCurrencyCode() {
        String code = null;
        writeMessage("Please choice currency code:");
        while (true) {
            code = readString();
            if (code.length() == 3)
                break;
            else
                writeMessage("Error, Please choice again:");
        }
        return code.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) {
        String[] cash;

        writeMessage("Input nominal and total:");

        while (true) {
            try {
                cash = readString().split(" ");
                if (Integer.parseInt(cash[0]) > 0 && Integer.parseInt(cash[1]) > 0 && cash.length == 2)
                    break;
            } catch (Exception e) {
                writeMessage("Error, Please choice again:");
                continue;
            }
            writeMessage("Error, Please choice again:");
        }
        return cash;
    }

    public static Operation askOperation() {
        writeMessage("Please choice method code:");
        Operation operation = null;

        while (true) {
            try {
                operation = Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
                break;
            }
            catch (IllegalArgumentException e) {
                writeMessage("Error, Please method again:");
            }
        }
        return operation;
    }
}
