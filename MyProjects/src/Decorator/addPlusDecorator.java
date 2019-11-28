package Decorator;

public class addPlusDecorator implements PrinterInterface{
    private PrinterInterface wrapper;

    public addPlusDecorator(PrinterInterface wrapper) {
        this.wrapper = wrapper;
    }

    @Override
    public void print() {
        System.out.print(" +++ ");
        wrapper.print();
        System.out.print(" +++ ");
    }
}
