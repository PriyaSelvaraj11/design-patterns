package singleton;

class GovernmentA {
    private static GovernmentA instance;
    public String presidentName;

    // making the constructor private
    private GovernmentA(String presidentName) {
        // The following code emulates slow initialization.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.presidentName = presidentName;
    }

    public static GovernmentA getInstance(String presidentName) {
        if (instance == null) {
            instance = new GovernmentA(presidentName);
        }
        return instance;
    }
}

// thread safe implementation
class GovernmentB {
    private static volatile GovernmentB instance;
    public String presidentName;

    private GovernmentB(String presidentName) {
        // The following code emulates slow initialization.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.presidentName = presidentName;
    }

    public static GovernmentB getInstance(String presidentName) {
        GovernmentB result = instance;
        if (result != null) {
            return result;
        }
        synchronized (GovernmentB.class) {
            if (instance == null) {
                instance = new GovernmentB(presidentName);
            }
            return instance;
        }
    }
}

// start of client code
public class SingletonExample {
    public static void main(String[] args) {
        System.out.println("If you see the same presidentName, then government instance was reused" + "\n" +
                "If you see different presidentNames, then 2 instances of government were created");
        Thread thread1 = new Thread(new Thread1());
        Thread thread2 = new Thread(new Thread2());
        thread1.start();
        thread2.start();
    }

    static class Thread1 implements Runnable {
        @Override
        public void run() {
            GovernmentB government = GovernmentB.getInstance("Ram");
            System.out.println(government.presidentName);
        }
    }

    static class Thread2 implements Runnable {
        @Override
        public void run() {
            GovernmentB government = GovernmentB.getInstance("Harry");
            System.out.println(government.presidentName);
        }
    }
}
// end of client code