package Serialization;

import java.io.*;

public class MainClass {
    final static String FILE_NAME = "c:\\File.dat";

    public static void serialize(ClassC object) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(object);

        fileOutputStream.close();
        objectOutputStream.close();
    }

    public static ClassC deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        ClassC object = (ClassC) objectInputStream.readObject();

        objectInputStream.close();

        return object;

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ClassC object = new ClassC("aaa");
        object.classCName = "ClassCName";
        object.classBName = "ClassBName";
        object.classAName = "ClassAName";

        MainClass.serialize(object);

        ClassC serializeObject = MainClass.deserialize();

        System.out.println(serializeObject.classCName);
        System.out.println(serializeObject.classBName);
        System.out.println(serializeObject.classAName);
    }
}
