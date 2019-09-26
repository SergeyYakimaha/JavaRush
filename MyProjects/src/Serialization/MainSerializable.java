package Serialization;

import java.io.*;

public class MainSerializable {
    final static String FILE_NAME = "c:\\File.dat";

    public static void serialize(Object object) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(object);

        fileOutputStream.close();
        objectOutputStream.close();
    }

    public static Object deserialize() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Object object = objectInputStream.readObject();

        objectInputStream.close();

        return object;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializableClass serializableClass = new SerializableClass();

        serialize(serializableClass);

        SerializableClass newObject = (SerializableClass) deserialize();
    }
}
