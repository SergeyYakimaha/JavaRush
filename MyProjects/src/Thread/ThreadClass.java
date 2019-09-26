package Thread;

public class ThreadClass implements Runnable{
    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted())
            System.out.println("Hello");
    }
}
