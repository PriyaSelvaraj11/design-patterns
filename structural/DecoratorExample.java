package decorator;

interface Car {
    public void assemble();
}

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

class HybridCar extends CarDecorator {
    HybridCar(Car car) {
        super(car);
    }

    public void assemble() {
        super.assemble();
        System.out.println(" adding hybrid engine!!!");
    }
}

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