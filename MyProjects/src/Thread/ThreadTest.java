package Thread;

public class ThreadTest extends Thread {
    @Override
    public void run() {
        while(!isInterrupted()){
            System.out.println("bye");
        }
    }
}
