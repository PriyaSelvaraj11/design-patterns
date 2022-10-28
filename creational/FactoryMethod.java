import java.util.*;
import java.lang.*;
import java.io.*;


interface Vehicle
{
    public void drive();
}

class Bus implements Vehicle
{
    public void drive() {
        System.out.println("driving bus!!!!");
    }
}

class Car implements Vehicle
{
    public void drive() {
        System.out.println("driving car!!!!");
    }
}

// Base factory class
abstract class VehicleDriver 
{
    /*  Factory method which the 
    *   subclasses will override in order to create 
    *   specific classes
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

class BusVehicleDriver extends VehicleDriver
{
    public Vehicle getVehicle() {
        return new Bus();
    }
}

class CarVehicleDriver extends VehicleDriver
{
    public Vehicle getVehicle() {
        return new Car();
    }
}

// start of client code 
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner reader = new Scanner(System.in); 
		String input = reader.next();
		reader.close();
		
        /* Factory method is used when there is a lot of generic processing in the class but
        * the sub class need to be decided during runtime
        */
		VehicleDriver busDriver;
		if(input.equals("bus")) {
			busDriver = new BusVehicleDriver();
		} else {
			busDriver = new CarVehicleDriver();
		}
		
        // generic method of the class
		busDriver.driveVehicle();
        
	}
}
// end of client code 
