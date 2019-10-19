package com.javarush.task.task37.task3707;

import java.io.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static class Cat implements Serializable {
        private String name;

        public Cat(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Cat> catList = new ArrayList<>(Arrays.asList(new Cat("1"), new Cat("2")));

        AmigoSet<Cat> amigoSet = new AmigoSet<>(catList);
        System.out.println(amigoSet);

        AmigoSet<Cat> amigoSetClone = (AmigoSet<Cat>) amigoSet.clone();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("c:/JavaRushData/AmigoSet.dat"));

        out.writeObject(amigoSet);
        out.flush();
        out.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("c:/JavaRushData/AmigoSet.dat"));

        AmigoSet amigoSetNew = (AmigoSet) in.readObject();
        in.close();

        System.out.println(amigoSetNew);
    }
}