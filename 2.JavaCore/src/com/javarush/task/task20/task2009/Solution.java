package com.javarush.task.task20.task2009;

import java.io.*;

/*
Как сериализовать static?
*/
public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;

        private void writeObject(ObjectOutputStream stream) throws IOException {
            stream.defaultWriteObject();
            stream.writeObject(staticString);
        }

        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            staticString = (String) stream.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClassWithStatic classWithStatic = new ClassWithStatic();

        FileOutputStream fileOutput = new FileOutputStream("c:\\TestData.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);

        outputStream.writeObject(classWithStatic);
        fileOutput.close();
        outputStream.close();

        ClassWithStatic.staticString = "11111";

        FileInputStream fileInput = new FileInputStream("c:\\TestData.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInput);
        classWithStatic = (ClassWithStatic)objectInputStream.readObject();
        fileInput.close();
        objectInputStream.close();

        System.out.println(ClassWithStatic.staticString);


   }
}
