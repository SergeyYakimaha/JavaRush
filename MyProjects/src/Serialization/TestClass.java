package Serialization;

import java.io.*;

public class TestClass {

    public static class ClassA {
        public int fieldIntA;
        public String fieldStringA;

        /*Должен быть конструктов по умолчанию */
        public ClassA(){
        }
    }

    public static class ClassB extends ClassA implements Serializable {
        public int fieldIntB;
        public String fieldStringB;

        private void writeObject(ObjectOutputStream out) throws IOException {
            out.defaultWriteObject();
            out.writeInt(fieldIntA);
            out.writeObject(fieldStringA);
        }

        private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
            in.defaultReadObject();
            fieldIntA = in.readInt();
            fieldStringA = (String) in.readObject();
        }

        public ClassB(int intB, String stringB) {
            this.fieldIntB = intB;
            this.fieldStringB = stringB;
            fieldIntA = this.fieldIntB * 2;
            fieldStringA = this.fieldStringB + "AAAA";
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileOutputStream fileOutputStream = new FileOutputStream("c:\\JavaRushData\\solution.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        FileInputStream fileInputStream = new FileInputStream("c:\\JavaRushData\\solution.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        ClassB classB = new ClassB(10, "BBBB");

        objectOutputStream.writeObject(classB);

        objectOutputStream.flush();
        objectOutputStream.close();

        ClassB cloneClassB = (ClassB) objectInputStream.readObject();

        objectInputStream.close();

        System.out.println("classB.fieldIntB = " + cloneClassB.fieldIntB);
        System.out.println("classB.fieldStringB = " + cloneClassB.fieldStringB);
        System.out.println("classB.fieldIntA = " + cloneClassB.fieldIntA);
        System.out.println("classB.fieldStringA = " + cloneClassB.fieldStringA);
    }
}
