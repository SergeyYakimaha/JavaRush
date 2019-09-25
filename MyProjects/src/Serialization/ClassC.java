package Serialization;

import java.io.Serializable;

public class ClassC extends ClassB implements Serializable {
    public String classCName;

    public ClassB classB;

    public ClassC(String name) {
        System.out.println("Конструктор ClassC");

    }
}
