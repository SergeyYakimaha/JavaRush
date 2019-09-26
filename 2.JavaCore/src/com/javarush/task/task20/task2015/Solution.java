package com.javarush.task.task20.task2015;

import java.io.*;

/* 
Переопределение сериализации
*/
public class Solution implements Serializable, Runnable{
    private transient Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        System.out.println(this.speed);
    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        Thread newThread = new Thread(this);
        newThread.start();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("c:\\JavaRushData\\solution.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        FileInputStream fileInputStream = new FileInputStream("c:\\JavaRushData\\solution.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Solution solution = new Solution(10);

        objectOutputStream.writeObject(solution);

        Solution newSolution = (Solution) objectInputStream.readObject();

        objectOutputStream.flush();
        objectOutputStream.close();
        objectInputStream.close();
    }
}
