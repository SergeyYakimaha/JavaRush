package com.javarush.task.task20.task2021;

import java.io.*;

/* 
Сериализация под запретом
*/
public class Solution implements Serializable {
    public static class SubSolution extends Solution {

        private void writeObject(ObjectOutputStream out) throws NotSerializableException {
            throw new NotSerializableException();
        }

        private void readObject(ObjectInputStream in) throws NotSerializableException {
            throw new NotSerializableException();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("c:\\JavaRushData\\solution.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        FileInputStream fileInputStream = new FileInputStream("c:\\JavaRushData\\solution.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        SubSolution subSolution = new SubSolution();

        objectOutputStream.writeObject(subSolution);

        objectOutputStream.close();
        fileOutputStream.close();

        objectInputStream.readObject();

        objectInputStream.close();
        fileInputStream.close();
    }
}
