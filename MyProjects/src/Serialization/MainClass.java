package Serialization;

import java.io.*;

public class MainClass {
    final static String FILE_NAME = "c:\\JavaRushData\\File.dat";

    public static void serialize(ClassA object) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(object);

        fileOutputStream.close();
        objectOutputStream.close();
    }

    public static Object deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        ClassA object = (ClassA) objectInputStream.readObject();

        objectInputStream.close();

        return object;

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClassC c = new ClassC("aaa");
        c.classB = new ClassB("bbb");
        c.classCName = "ClassCName";
        c.classBName = "ClassBName";
        c.classAName = "ClassAName";

        MainClass.serialize(c);

        ClassC serializeObject = (ClassC)MainClass.deserialize();
        System.out.println(serializeObject.classB.classBName);

        System.out.println(serializeObject.classCName);
        System.out.println(serializeObject.classBName);
        System.out.println(serializeObject.classAName);
    }
}
