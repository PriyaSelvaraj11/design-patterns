class Bus
{
    drive() {
        console.log("driving bus!!!!");
    }
}

class Car
{
    drive() {
        console.log("driving car!!!!");
    }
}

// Base factory class
class VehicleDriver 
{
    /**
    * Generic method for the class
     */
    driveVehicle() {
        const vehicle = this.getVehicle();
        vehicle.drive();
    }
}

class BusVehicleDriver extends VehicleDriver
{
    getVehicle() {
        return new Bus();
    }
}

class CarVehicleDriver extends VehicleDriver
{
    getVehicle() {
        return new Car();
    }
}


// start of client code 

// Factory method pattern is used when there is a lot of generic processing in the class but
// the sub class need to be decided during runtime
let driver = new BusVehicleDriver();
driver.driveVehicle();

driver = new CarVehicleDriver();
driver.driveVehicle();

// end of client code 
