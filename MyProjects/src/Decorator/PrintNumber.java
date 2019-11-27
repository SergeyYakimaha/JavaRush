package Decorator;

public class PrintNumber implements PrinterInterface {
    @Override
    public void print() {
        System.out.print("123456");
    }
}
