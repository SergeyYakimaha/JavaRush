package com.javarush.task.task17.task1711;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        DateFormat dateFormatInput = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        DateFormat dateFormatOutput = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length - 2; i += 3) {
                        String name = args[i];
                        Sex sex = (args[i + 1].equals("м")) ? Sex.MALE : Sex.FEMALE;
                        Date bd = dateFormatInput.parse(args[i + 2]);
                        if (sex == Sex.MALE)
                            allPeople.add(allPeople.size(), Person.createMale(name, bd));
                        else
                            allPeople.add(allPeople.size(), Person.createFemale(name, bd));
                        System.out.println(allPeople.size() - 1);
                    }
                    break;
                }
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length - 3; i += 4) {
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(args[i + 1]);
                        person.setSex((args[i + 2].equals("м")) ? Sex.MALE : Sex.FEMALE);
                        person.setBirthDate(dateFormatInput.parse(args[i + 3]));
                    }
                    break;
                }
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDate(null);
                    }
                    break;
                }
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        Person person = allPeople.get(Integer.parseInt(args[i]));
                        System.out.print(person.getName() + " ");
                        System.out.print(((person.getSex() == Sex.MALE) ? "м" : "ж") + " ");
                        System.out.println(dateFormatOutput.format(person.getBirthDate()));
                    }
                    break;
                }
        }
    }
}
