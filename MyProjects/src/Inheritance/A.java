package Inheritance;

public class A {
    private int a;
    private int b;

    public static int i = 0;
    public String name;

    public A(String name) {
        this.name = name;
        ++i;
    }
}
