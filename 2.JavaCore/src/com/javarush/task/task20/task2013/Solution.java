package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/* 
Externalizable Person
*/
public class Solution {
    public static final String FILE_NAME_ = "c:\\1.dat";

    public static void serializable(Person object) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_NAME_, true));
        objectOutputStream.writeObject(object);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public static Person deserializable() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_NAME_));
        Person object = (Person) objectInputStream.readObject();
        objectInputStream.close();
        return object;
    }

    public static class Person implements Externalizable{
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

        public Person(){
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

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeChars(firstName);
            out.writeChars(lastName);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = in.readLine();
            lastName = in.readLine();
            father = (Person)in.readObject();
            mother = (Person)in.readObject();
            age = in.readInt();
            children = (List)in.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person mother = new Person("Люда","Якимаха", 68);
        Person father = new Person("Юра","Якимаха", 70);
        Person son = new Person("Саша","Якимаха", 8);
        Person daughter = new Person("Даша","Якимаха", 15);

        Person I = new Person("Серега", "Якимаха", 41);
        I.setMother(mother);
        I.setFather(father);
        I.setChildren(Arrays.asList(son, daughter));

//        serializable(mother);
//        serializable(father);
//        serializable(son);
//        serializable(daughter);
        serializable(I);

//        Person.serializable(I);
//
       Person myClone = deserializable();


    }
}
