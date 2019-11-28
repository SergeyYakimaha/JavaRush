package Decorator;

public class DecoratorApp {

    public static void main(String[] args) {

        PrinterInterface pPMPChars = new addPlusDecorator(new addMinusDecorator(new addPlusDecorator(new PrintChars())));
        PrinterInterface pPMChars = new addPlusDecorator(new addMinusDecorator(new PrintChars()));
        PrinterInterface pPNumber = new addPlusDecorator(new PrintNumber());

        pPMPChars.print();
        System.out.println();
        pPMChars.print();
        System.out.println();
        pPNumber.print();
    }

}
