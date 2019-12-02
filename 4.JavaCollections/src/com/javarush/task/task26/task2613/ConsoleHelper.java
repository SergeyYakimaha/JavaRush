package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {
    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() + ".resources.common_en");

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String result = null;
        try {
            result = bis.readLine();
            if ("EXIT".equals(result.toUpperCase())) {
                //ConsoleHelper.writeMessage(res.getString("the.end"));
                throw new InterruptOperationException();
            }
            return result;
        } catch (IOException e) {
        }
        return null;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        String result = "";
        while (result.length() != 3) {
            writeMessage(res.getString("choose.currency.code"));
            result = readString();
        }
        return result.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        String[] result = new String[2];


        String inString = "";
        while (!inString.matches("^\\d+ \\d+$")) {
            writeMessage(res.getString("choose.denomination.and.count.format"));
            inString = readString();
        }
        result[0] = inString.substring(0, inString.indexOf(' '));
        result[1] = inString.substring(inString.indexOf(' ') + 1);

        return result;
    }

    public static Operation askOperation() throws InterruptOperationException {
        boolean isOperation = false;
        while (!isOperation) {
            try {
                //writeMessage("Enter number of operation (1 - INFO, 2 — DEPOSIT, 3 — WITHDRAW, 4 — EXIT):");
                writeMessage(res.getString("choose.operation") +
                        " (1 - " + res.getString("operation.INFO") +
                        ", 2 — " + res.getString("operation.DEPOSIT") +
                        ", 3 — " + res.getString("operation.WITHDRAW") +
                        ", 4 — " + res.getString("operation.EXIT") + "):");
                int numberOfOperation = Integer.parseInt(readString());
                Operation operation = Operation.getAllowableOperationByOrdinal(numberOfOperation);
                return operation;
            } catch (IllegalArgumentException e) {
            }
        }
        return null;
    }

    public static void printExitMessage() {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }
}
