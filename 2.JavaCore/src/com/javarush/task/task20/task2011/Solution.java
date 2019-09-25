package com.javarush.task.task20.task2011;

import java.io.*;

/*
Externalizable для апартаментов
*/
public class Solution {

    public static class Apartment implements Externalizable {
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(address);
            out.writeInt(year);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            address =  (String) in.readObject();
            year = in.readInt();
        }

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() {
            super();
        }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return("Address: " + address + "\n" + "Year: " + year);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("c:\\1.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        FileInputStream fileInputStream = new FileInputStream("c:\\1.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Apartment apr = new Apartment("Apartment", 1980);

        objectOutputStream.writeObject(apr);
        objectOutputStream.flush();
        objectOutputStream.close();

        Apartment apr1 = (Apartment) objectInputStream.readObject();
        objectInputStream.close();

        System.out.println(apr1.toString());


    }
}
