package com.javarush.task.task20.task2012;

import java.io.*;

/* 
OutputToConsole
*/
public class Solution {
    public static String greeting = "Hello world";
    public static final String FILE_NAME = "C:\\JavaRushData\\OutputToConsole.dat";

    /**
     * OutputToConsole is an inner base class for improving your attentiveness.
     * An OutputToConsole object encapsulates the information needed
     * for displaying the [greeting] variable to the console.
     * @author JavaRush
     */
    public static class OutputToConsole implements Externalizable {
        private int counter;

        /**
         * @param out A stream for externalization
         * @throws java.io.IOException
         */
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(counter);
        }

        /**
         * @param in A stream for de-externalization
         * @throws java.io.IOException
         * @throws ClassNotFoundException
         */
        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            counter = in.readInt();
        }

        /**
         * Class constructor that sets the private counter field.
         */
        public OutputToConsole(int counter) {
            this.counter = counter;
        }

        public OutputToConsole() {
        }

        /**
         * Prints greeting message to console counter times.
         */
        public void printMessage() {
            for (int i = 0; i < counter; i++) {
                System.out.println(greeting);
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        OutputToConsole outputToConsole = new OutputToConsole(6);

        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(outputToConsole);

        objectOutputStream.close();
        fileOutputStream.close();

        FileInputStream fileinputStream = new FileInputStream(FILE_NAME);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileinputStream);

        OutputToConsole object = (OutputToConsole) objectInputStream.readObject();

        objectInputStream.close();
        fileinputStream.close();

        object.printMessage();


    }
}
