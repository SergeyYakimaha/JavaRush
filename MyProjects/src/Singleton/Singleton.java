package Singleton;

public class Singleton {

    private static volatile Singleton instance;

    /** private constructor to prevent others from instantiating this class */
    private Singleton() {}

    /** Lazily initialize the singleton in a synchronized block */
    public static Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                // double-check
                if(instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
