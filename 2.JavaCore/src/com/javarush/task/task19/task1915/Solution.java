package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        String fileName;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        fileName = bufferedReader.readLine();
        bufferedReader.close();

        PrintStream consoleStream = System.out;
        /* можно сделать так и перенаправлять весь консольный вывод сразу в файл

        PrintStream ps = new PrintStream(new FileOutputStream(fileName));
        System.setOut(ps);
        testString.printSomething();
        */
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);

        FileOutputStream fileOutputStream = new FileOutputStream(new File(fileName));

        System.setOut(printStream);
        testString.printSomething();
        fileOutputStream.write(byteArrayOutputStream.toByteArray());
        fileOutputStream.close();

        System.setOut(consoleStream);
        System.out.println(byteArrayOutputStream.toString());

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

