package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Externalizable Person
*/
public class Solution {


    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Person() {
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        public static void serializable(Person person) throws IOException {
            FileOutputStream fileOutputStream = new FileOutputStream("c:\\JavaRushData\\person.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(person);

            objectOutputStream.flush();
            objectOutputStream.close();
        }

        public static Person deserializable() throws IOException, ClassNotFoundException {
            FileInputStream fileInputStream = new FileInputStream("c:\\JavaRushData\\person.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Person person = (Person) objectInputStream.readObject();

            objectInputStream.close();

            return person;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(father);
            out.writeObject(mother);
            out.writeUTF(firstName);
            out.writeUTF(lastName);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            father = (Person) in.readObject();
            mother = (Person) in.readObject();
            firstName = in.readUTF();
            lastName = in.readUTF();
            age = in.readInt();
            children = (List) in.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person mother = new Person("Люда", "Петров", 60);
        Person father = new Person("Юра", "Петров", 65);
        Person son = new Person("Даша", "Петров", 10);
        Person daughter = new Person("Саша", "Петров", 20);

        Person sergey = new Person("Сергей", "Петров", 41);
        sergey.setMother(mother);
        sergey.setFather(father);
        sergey.setChildren(Arrays.asList(daughter, son));

        Person.serializable(sergey);

        Person cloneSergey = Person.deserializable();
        System.out.println(cloneSergey.age);
        System.out.println(cloneSergey.mother.firstName);
        System.out.println(cloneSergey.father.firstName);
        for (Person person: cloneSergey.children){
            System.out.println(person.firstName);
        }
    }
}
