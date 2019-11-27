package Decorator;

public class addMinusDecorator implements PrinterInterface {
    private PrinterInterface wrapper;

    public addMinusDecorator(PrinterInterface wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public void print() {
        System.out.print(" --- ");
        wrapper.print();
        System.out.print(" --- ");
    }
}
