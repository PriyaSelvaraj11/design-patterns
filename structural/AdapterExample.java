package adapter;

/**
 * PROBLEM: There exists an application with vehicle interface. Driver class
 * gets an object of vehicle type and triggers vehicle.drive() method.
 * Bicycle class exists with peddle() implementation. Make the driver class to
 * accept bicycle object as input.
 * 
 * SOLUTION: Build a adapter class to make bicycle class compatabile with driver
 * class.
 * 
 * Service class - the driver class which uses the vehicle interface
 * Adapter class - gets incompatible object as input and implements vehicle
 * interface behaviour
 */

// Compatible interface
interface Vehicle {
    public void drive();
}

// Compatible class
class Car implements Vehicle {
    public void drive() {
        System.out.println("driving car...");
    }
}

// InCompatible class
class BiCycle {
    public void peddle() {
        System.out.println("peddling bicycle...");
    }
}

// Adapter for bicycle to make it compatible with Driver class
class BiCycleAdapter implements Vehicle {
    BiCycle bicycle;

    BiCycleAdapter(BiCycle bicycle) {
        this.bicycle = bicycle;
    }

    public void drive() {
        bicycle.peddle();
    }
}

// Service using the vehicle interface
class Driver {
    public void driveVehicle(Vehicle vehicle) {
        vehicle.drive();
    }
}

// start of client code
public class AdapterExample {
    public static void main(String[] args) throws java.lang.Exception {
        BiCycle bicycle = new BiCycle();

        Driver driver = new Driver();
        driver.driveVehicle(new BiCycleAdapter(bicycle));
        driver.driveVehicle(new Car());
    }
}
// end of client code

// OUTPUT
// peddling bicycle...
// driving car...
