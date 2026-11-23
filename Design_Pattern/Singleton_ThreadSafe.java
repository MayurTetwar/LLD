package Design_Pattern;

public class Singleton_ThreadSafe {
    private static Singleton_ThreadSafe instance = null;

    private Singleton_ThreadSafe() {
        System.out.println("Singleton Constructor Called!");
    }

    // Double check locking..
    public static Singleton_ThreadSafe getInstance() {
        if (instance == null) { // First check (no locking)
            synchronized (Singleton_ThreadSafe.class) { // Lock only if needed
                if (instance == null) { // Second check (after acquiring lock)
                    instance = new Singleton_ThreadSafe();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton_ThreadSafe s1 = Singleton_ThreadSafe.getInstance();
        Singleton_ThreadSafe s2 = Singleton_ThreadSafe.getInstance();

        System.out.println(s1 == s2);
    }
}
/*
// Fast Initilization but more cpu and memory useage

public class ThreadSafeEagerSingleton {
    private static ThreadSafeEagerSingleton instance = new ThreadSafeEagerSingleton();

    private ThreadSafeEagerSingleton() {
        System.out.println("Singleton Constructor Called!");
    }

    public static ThreadSafeEagerSingleton getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        ThreadSafeEagerSingleton s1 = ThreadSafeEagerSingleton.getInstance();
        ThreadSafeEagerSingleton s2 = ThreadSafeEagerSingleton.getInstance();

        System.out.println(s1 == s2);
    }
}
*/