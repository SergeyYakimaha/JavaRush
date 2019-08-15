package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        ArrayList<String> wordList = new ArrayList<String>(Arrays.asList("user", "loser", "coder", "proger"));

        while (wordList.contains(key = reader.readLine())) {
            switch (key) {
                case "user": {
                    person = new Person.User();
                    doWork(person);
                    break;
                }
                case "loser": {
                    person = new Person.Loser();
                    doWork(person);
                    break;
                }
                case "coder": {
                    person = new Person.Coder();
                    doWork(person);
                    break;
                }
                case "proger": {
                    person = new Person.Proger();
                    doWork(person);
                    break;
                }
            }

            //doWork(person); //вызываем doWork

        }
    }

    public static void doWork(Person person) {
        if (person instanceof Person.User) {
            ((Person.User) person).live();
        }
        if (person instanceof Person.Loser) {
            ((Person.Loser) person).doNothing();
        }
        if (person instanceof Person.Coder) {
            ((Person.Coder) person).writeCode();
        }
        if (person instanceof Person.Proger) {
            ((Person.Proger) person).enjoy();
        }
    }
}