package flyweight;

import java.util.*;
/**
 * PROBLEM: Build a car manufacturing application which builds suv/sedan car types.
 *          Imagine cartype variable is huge and storing many objects is an expensive operation.
 * 
 * SOLUTION: 
 * Flyweight factory - manages the pool of cartype flyweights. Used for flyweight creation.
 * Flyweight class - cartype class that is shared amount different car objects.(repeating state)
 * Context class - maintains unique properties and flyweight instance.
 */

 // Context class
class Car {
    protected int id;
    protected CarType carType;

    Car(int id, CarType carType) {
        this.id = id;
        this.carType = carType;
    }

    public int getId() {
        return this.id;
    }

    public String getType() {
        return carType.getName();
    }

    public void manufacture() {
        carType.manufacture(id);
    }
}

// Flyweight class which stores some of the attributes of Car class
class CarType {
    protected String name;

    CarType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void manufacture(int id) {
        System.out.println("manufacturing car of type: " + name + " with id: " + id);
    }
}

// Factory to get the flyweight
class CarFactory {
    static Map<String, CarType> carTypes = new HashMap<String, CarType>();

    public static CarType getCarType(String name) {
        CarType result = carTypes.get(name);
        if (result == null) {
            result = new CarType(name);
            carTypes.put(name, result);
        }
        return result;
    }
}

// Client class dealing with cars
class CarDealer {
    private List<Car> cars = new ArrayList<>();

    public void manufactureCar(int id, String name) {
        CarType type = CarFactory.getCarType(name);
        Car car = new Car(id, type);
        cars.add(car);
    }

    public void deliverCars() {
        for (Car car : cars) {
            System.out.println("Delivering car with id: " + car.getId() + " type: " + car.getType());
        }
    }
}

// start of client code
public class FlyweightExample {
    public static void main(String[] args) throws java.lang.Exception {
        CarDealer carDealer = new CarDealer();
        carDealer.manufactureCar(1, "suv");
        carDealer.manufactureCar(2, "suv");
        carDealer.manufactureCar(3, "suv");
        carDealer.manufactureCar(4, "sedan");

        carDealer.deliverCars();

    }
}
// end of client code

// OUTPUT
// Delivering car with id: 1 type: suv
// Delivering car with id: 2 type: suv
// Delivering car with id: 3 type: suv
// Delivering car with id: 4 type: sedan
