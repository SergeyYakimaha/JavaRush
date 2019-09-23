package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();
    private static String fileName;

    public static void main(String[] args) throws IOException, ParseException {
        fileName = args[0];

        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line;
        SimpleDateFormat df = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);

        while ((line = bufferedReader.readLine()) != null) {
            String[] strings = line.split("\\s");
            String name = "";
            String birthDate = "";

            for (int i = 0; i < strings.length; i++) {
                try {
                    birthDate = birthDate + Integer.parseInt(strings[i]) + " ";
                } catch (NumberFormatException e) {
                    name = name + strings[i] + " ";
                }
            }

            //name = line.replaceAll("\\d", "").trim();

            PEOPLE.add(new Person(name.trim(), df.parse(birthDate.trim())));
        }
        bufferedReader.close();
    }
}
