package Decorator;

public class DecoratorApp {

    public interface PrinterInterface {
        void print();
    }

    static class PrintNumber implements PrinterInterface{
        @Override
        public void print() {
            System.out.println("1 2 3 4 5");
        }
    }

    static class PrintChars implements PrinterInterface{
        @Override
        public void print() {
            System.out.println("z x c v b");
        }
    }

    static class addNameDecorator implements PrinterInterface {
        private PrinterInterface wrapper;

        public addNameDecorator(PrinterInterface wrapper) {
            this.wrapper = wrapper;
        }

        @Override
        public void print() {
            System.out.println("-------------");
            wrapper.print();
        }
    }

    public static void main(String[] args) {
        PrinterInterface chars = new PrintChars();
        chars.print();

        PrinterInterface pChars = new addNameDecorator(new PrintChars());
        PrinterInterface pNumber = new addNameDecorator(new PrintNumber());

        pChars.print();
        pNumber.print();
    }

}
