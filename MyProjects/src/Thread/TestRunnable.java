package Thread;

public class TestRunnable implements Runnable {
    private int i;

    public TestRunnable(int value) {
        this.i = value;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(i);
                System.out.println(i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        TestRunnable testRunnable = new TestRunnable(100);
        TestRunnable testRunnable1 = new TestRunnable(200);
        Thread thread = new Thread(testRunnable);
        //Thread thread1 = new Thread(testRunnable1);

        thread.start();
        //thread1.start();
        Thread.sleep(500);
        System.out.println("Проснулся");

        System.out.println("чсмчсм");


    }
}
