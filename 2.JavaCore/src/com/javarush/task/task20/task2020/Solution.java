package com.javarush.task.task20.task2020;

import java.io.*;
import java.util.logging.Logger;

/* 
Сериализация человека
*/
public class Solution {

<<<<<<< HEAD
    public static final String FILE_NAME = "C:\\JavaRushData\\person.dat";
=======
    public static final String FILE_NAME = "C:\\person.dat";
>>>>>>> 5fb853656e18cd8820a48ede24df03cc38238e1d

    public static void serializable(Person person) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(person);

<<<<<<< HEAD
        objectOutputStream.flush();
=======
>>>>>>> 5fb853656e18cd8820a48ede24df03cc38238e1d
        objectOutputStream.close();
        fileOutputStream.close();
    }

    public static Person deserializable() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Person person = (Person) objectInputStream.readObject();

        objectInputStream.close();

        return person;
    }

<<<<<<< HEAD
    //public static class Person implements Serializable {
    public static class Person implements Externalizable {
=======
    public static class Person implements Serializable {
>>>>>>> 5fb853656e18cd8820a48ede24df03cc38238e1d
        String firstName;
        String lastName;
        transient String fullName;
        transient String greeting;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

<<<<<<< HEAD
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            System.out.println("writeExternal");
            out.writeObject(this.firstName);
            out.writeObject(this.lastName);
            out.writeObject(this.sex);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            System.out.println("readExternal");
            this.firstName = (String)in.readObject();
            this.lastName = (String)in.readObject();
            this.sex = (Sex) in.readObject();
        }

        public Person(){
            System.out.println("constructor");
        }

=======
>>>>>>> 5fb853656e18cd8820a48ede24df03cc38238e1d
        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greeting = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
            out.writeObject(firstName + " " + lastName);
            out.writeObject(greeting);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            fullName = (String)in.readObject();
            greeting = (String)in.readObject();
            outputStream = System.out;
            logger = Logger.getLogger(String.valueOf(this));
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("Сергей", "Иванов", "Украина", Sex.MALE);

        Solution.serializable(person);

        Person clonePerson = Solution.deserializable();

        System.out.println(clonePerson.firstName);
        System.out.println(clonePerson.lastName);
        System.out.println(clonePerson.fullName);
        System.out.println(clonePerson.country);
        System.out.println(clonePerson.greeting);
        System.out.println(clonePerson.sex);
        System.out.println(clonePerson.logger);
    }
}
