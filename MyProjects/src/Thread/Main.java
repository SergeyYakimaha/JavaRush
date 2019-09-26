package Thread;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ThreadClass object = new ThreadClass();
        Thread thread = new Thread(object);
        ThreadTest threadTest = new ThreadTest();
        threadTest.start();
        threadTest.join();
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
        threadTest.interrupt();
    }
}
