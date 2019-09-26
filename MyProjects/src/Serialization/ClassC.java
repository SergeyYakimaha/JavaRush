package Serialization;

import java.io.Serializable;

public class ClassC extends ClassB implements Serializable {
    public String classCName;
    public String name;
    private int i;
    static final long serialVersionUID = 1L;

    public ClassC(String name) {
        System.out.println("Конструктор ClassC");

    }
}
