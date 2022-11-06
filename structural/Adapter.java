import java.util.*;
import java.lang.*;
import java.io.*;

interface Vehicle {
    public void drive();
}

class Car implements Vehicle {
    public void drive() {
        System.out.println("driving car...");
    }
}

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

class Driver {
    public void driveVehicle(Vehicle vehicle) {
        vehicle.drive();
    }
}

class Main {
    public static void main (String[] args) throws java.lang.Exception
	{
        BiCycle bicycle = new BiCycle();

        Driver driver = new Driver();
        driver.driveVehicle(new BiCycleAdapter(bicycle));
        driver.driveVehicle(new Car());
    }
}
