package Inheritance;

public class TestClass {
    public static void main(String[] args) {
        A a1 = new A("name 1");
        System.out.println(a1.i);
        A a2 = new A("name 2");
        System.out.println(a2.i);

        B b1 = new B("name 3");
        System.out.println(b1.i);
        System.out.println(B.i);

        System.out.println(a1.i);

    }
}
