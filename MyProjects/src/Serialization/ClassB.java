package Serialization;

import java.io.Serializable;

public class ClassB extends ClassA implements Serializable{
    public String classBName;

    ClassB classB;

    public ClassB(String name){
        this.classBName = name;
    }

    public ClassB(){
        System.out.println("Конструктор ClassB");
    }
}
