package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        Person person = null;

        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        if (!args[0].equals("-c"))
            person = allPeople.get(Integer.parseInt(args[1]));

        switch (args[0]) {
            case ("-c"):
                Date date = formatter.parse(args[3]);
                if (args[2].equals("м")) allPeople.add(allPeople.size(), Person.createMale(args[1], date));
                else
                    allPeople.add(allPeople.size(), Person.createFemale(args[1], date));
                System.out.println(allPeople.size() - 1);
                break;
            case ("-u"):
                Date date1 = formatter.parse(args[4]);
                person.setName(args[2]);
                person.setSex((args[3]) == "м" ? Sex.MALE : Sex.FEMALE);
                person.setBirthDate(date1);
                break;
            case ("-d"):
                person.setName(null);
                person.setSex(null);
                person.setBirthDate(null);
                break;
            case ("-i"):
                System.out.print(person.getName() + " ");
                System.out.print((person.getSex() == Sex.MALE) ? "м " : "ж ");
                formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
                System.out.print(formatter.format(person.getBirthDate()));
                break;
            default:
        }
    }
}
