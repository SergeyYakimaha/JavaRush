package com.javarush.task.task07.task0726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Не компилируется задача про котиков
*/

public class Solution {
    public final static ArrayList<Cat> CATS = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> strings = new ArrayList<String>();

        while (true) {
            String name = reader.readLine();

            if (name == null || name.isEmpty()) {
                break;
            }

            strings.add(name);
        }

        for (int i = 0; i < strings.size(); ) {
            Cat cat;
            cat = new Cat(strings.get(i),
                    Integer.parseInt(strings.get(i + 1)),
                    Integer.parseInt(strings.get(i + 2)),
                    Integer.parseInt(strings.get(i + 3)));
            CATS.add(cat);
            i = i + 4;
        }

        printList();
    }

    public static void printList() {
        for (int i = 0; i < CATS.size(); i++) {
            System.out.println(CATS.get(i));
        }
    }

    public static class Cat {
        private String name;
        private int age;
        private int weight;
        private int tailLength;

        Cat(String name, int age, int weight, int tailLength) {
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.tailLength = tailLength;
        }

        @Override
        public String toString() {
            return "Cat's name: " + name + ", age: " + age + ", weight: " + weight + ", tail: " + tailLength;
        }
    }
}