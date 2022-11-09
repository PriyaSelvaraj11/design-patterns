package factoryMethod;

import java.util.*;

/**
 * PROBLEM: Build a "find driver for vehicle" application based on the vehicle
 * type-car/bus
 * 
 * SOLUTION:
 * 
 * Product interface - declares methods all product classes should define
 * Concrete product class - defines the methods needed by creator and client
 * Creator class - declares abstract factory methods for concrete creator class
 * and defines common functions.(vehicledriver)
 * Concrete Creator class - creates the actual concrete product to be returned
 */

// Product interface
interface Vehicle {
    public void drive();
}

// Product class 1
class Bus implements Vehicle {
    public void drive() {
        System.out.println("driving bus!!!!");
    }
}

// Product class 2
class Car implements Vehicle {
    public void drive() {
        System.out.println("driving car!!!!");
    }
}

// Base Creator class
abstract class VehicleDriver {
    /*
     * Factory method which the
     * subclasses will override in order to create
     * specific classes
     */
    public abstract Vehicle getVehicle();

    /**
     * Generic method for the class
     */
    public void driveVehicle() {
        Vehicle vehicle = this.getVehicle();
        vehicle.drive();
    }
}

// Concrete creator class 1
class BusVehicleDriver extends VehicleDriver {
    public Vehicle getVehicle() {
        return new Bus();
    }
}

// Concrete creator class 2
class CarVehicleDriver extends VehicleDriver {
    public Vehicle getVehicle() {
        return new Car();
    }
}

// start of client code
public class FactoryMethodExample {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner reader = new Scanner(System.in);
        String input = reader.next();
        reader.close();

        /*
         * Factory method is used when there is a lot of generic processing in the class
         * but the sub class need to be decided during runtime
         */
        VehicleDriver driver;
        if (input.equals("bus")) {
            driver = new BusVehicleDriver();
        } else {
            driver = new CarVehicleDriver();
        }

        // generic method of the class
        driver.driveVehicle();

    }
}
// end of client code
