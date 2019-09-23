package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.beans.PropertyEditorSupport;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        System.setOut(printStream);

        testString.printSomething();

        String[] string = byteArrayOutputStream.toString().split("\\s");
        String result = null;

        switch (string[1]) {
            case "+": {
                result = byteArrayOutputStream.toString().trim() + " " + (Integer.parseInt(string[0]) + Integer.parseInt(string[2]));
                break;
            }
            case "-": {
                result = byteArrayOutputStream.toString().trim() + " " + (Integer.parseInt(string[0]) - Integer.parseInt(string[2]));
                break;
            }
            case "*": {
                result = byteArrayOutputStream.toString().trim() + " " + (Integer.parseInt(string[0]) * Integer.parseInt(string[2]));
                break;
            }
        }

        System.setOut(consoleStream);
        System.out.print(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

