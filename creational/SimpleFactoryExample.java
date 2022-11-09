import simpleFactory;

/**
 * PROBLEM: Build a application that builds chair.
 * 
 * SOLUTION: Add a factory method to build the chair from the actual class
 * 
 * Product interface - declares methods for concrete product class
 * Concrete class - defines specific method implementation.
 * Simple factory class - creates the instance of the chair
 */

// Product interface
interface Chair {
    public int getNumberOfLegs();

    public float getHeight();
}

// Concrete class
class PlasticChair implements Chair {
    protected int numberOfLegs;
    protected float height;

    public PlasticChair(int numberOfLegs, float height) {
        this.numberOfLegs = (int) numberOfLegs;
        this.height = height;
    }

    public int getNumberOfLegs() {
        return this.numberOfLegs;
    }

    public float getHeight() {
        return this.height;
    }
}

/*
 * Simple factory class which creates an instance
 * without exposing any instantiation logic to the caller
 */
class ChairFactory {
    public static Chair makeChair(int numberOfLegs, float height) {
        return new PlasticChair(numberOfLegs, height);
    }
}

// start of client code
public class SimpleFactoryExample {
    public static void main(String[] args) throws java.lang.Exception {
        Chair chair = ChairFactory.makeChair(3, 4.5f);
        System.out.println(chair.getNumberOfLegs());
    }
}
// end of client code
