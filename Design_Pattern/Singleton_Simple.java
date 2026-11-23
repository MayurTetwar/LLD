package Design_Pattern;

public class Singleton_Simple {
    private static Singleton_Simple instance = null;

    private Singleton_Simple() {
        System.out.println("Singleton Constructor called");
    }

    public static Singleton_Simple getInstance() {
        if (instance == null) {
            instance = new Singleton_Simple();
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton_Simple s1 = Singleton_Simple.getInstance();
        Singleton_Simple s2 = Singleton_Simple.getInstance();

        System.out.println(s1 == s2);
    }
}

/*
public class NoSingleton {
    public NoSingleton() {
        System.out.println("Singleton Constructor called. New Object created.");
    }

    public static void main(String[] args) {
        NoSingleton s1 = new NoSingleton();
        NoSingleton s2 = new NoSingleton();

        System.out.println(s1 == s2);
    }
}
*/