package MyProjects.src.Decorator;

public class DecoratorApp {

    public interface PrinterInterface {
        void print();
    }

    static class PrintNumber implements PrinterInterface{
        @Override
        public void print() {
            System.out.print("123456");
        }
    }

    static class PrintChars implements PrinterInterface{
        @Override
        public void print() {
            System.out.print("ZAQXSW");
        }
    }

    static class addPlusDecorator implements PrinterInterface {
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

    static class addMinusDecorator implements PrinterInterface {
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

    public static void main(String[] args) {
        PrinterInterface pMPChars = new addMinusDecorator(new addPlusDecorator(new PrintChars()));
        PrinterInterface pPMChars = new addPlusDecorator(new addMinusDecorator(new PrintChars()));
        PrinterInterface pPNumber = new addPlusDecorator(new PrintNumber());

        pMPChars.print();
        System.out.println();
        pPMChars.print();
        System.out.println();
        pPNumber.print();
    }

}
