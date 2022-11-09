package decorator;

/**
 * PROBLEM : Build a application that builds car with various features(hybrid
 * engine, auto gear) w.r.t the client needed.
 * 
 * NAIVE SOLUTION : have method constructCar(boolean addHybrid,boolean
 * addAutogear) with if..else condition in implementation.
 * 
 * SOLUTION: Make each feature as wrapper classes of car.
 * 
 * Component interface - declares method for both concrete class and wrapper
 * class
 * Concrete component class - Base behaviour definition
 * Base decorator class - Base decorator behaviour definition. Gets and outputs
 * the component interface.
 * Concrete decorator class - Specific concrete definition.
 */

// Component interface
interface Car {
    public void assemble();
}

// Concrete component interface
class BasicCar implements Car {
    public void assemble() {
        System.out.println(" assembling basic car!!!");
    }
}

// Base decorator class
class CarDecorator implements Car {
    protected Car car;

    CarDecorator(Car car) {
        this.car = car;
    }

    public void assemble() {
        this.car.assemble();
    }
}

// Concrete decoraror class 1
class HybridCar extends CarDecorator {
    HybridCar(Car car) {
        super(car);
    }

    public void assemble() {
        super.assemble();
        System.out.println(" adding hybrid engine!!!");
    }
}

// Concrete decoraror class 2
class AutomaticCar extends CarDecorator {
    AutomaticCar(Car car) {
        super(car);
    }

    public void assemble() {
        super.assemble();
        System.out.println(" adding auto gear!!!");
    }
}

// start of client code
public class DecoratorExample {
    public static void main(String[] args) throws java.lang.Exception {
        Car hybridCar = new HybridCar(new BasicCar());
        hybridCar.assemble();
        System.out.println("-------");

        Car hybridAutoCar = new AutomaticCar(new HybridCar(new BasicCar()));
        hybridAutoCar.assemble();
    }
}
// end of client code

// OUTPUT
// assembling basic car!!!
// adding hybrid engine!!!
// -------
// assembling basic car!!!
// adding hybrid engine!!!
// adding auto gear!!!