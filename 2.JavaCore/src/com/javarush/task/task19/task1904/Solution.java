package com.javarush.task.task19.task1904;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
        PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(new Scanner(new File("c:\\1\\1.txt")));
        System.out.printf(personScannerAdapter.read().toString());
    }

    public static class PersonScannerAdapter implements PersonScanner{
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            String[] stringBuffer = fileScanner.nextLine().split("\\s");
            DateFormat dateFormat = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            Date birthDate = dateFormat.parse(stringBuffer[3] + " " + stringBuffer[4] + " " + stringBuffer[5]);
            return new Person(stringBuffer[1], stringBuffer[2], stringBuffer[0], birthDate);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
