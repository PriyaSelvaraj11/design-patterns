package facade;

class DetergentHolderDispenser {
    int detergentInMl;

    DetergentHolderDispenser(int detergentInMl) {
        this.detergentInMl = detergentInMl;
    }

    public void dispenseDetergent() {
        System.out.println("Dispensing detergent of " + detergentInMl + " ml.");
    }
}

class WashAction {
    public static void wash() {
        System.out.println("washing clothes");
    }
}

class RinseAction {
    public static void rinse() {
        System.out.println("rinsing clothes");
    }
}

class SpinAction {
    public static void spin() {
        System.out.println("spinning to remove excess water");
    }
}

// Facade class that hides the internal steps of washing machine
class WashingMachine {
    DetergentHolderDispenser detergentHolderDispenser;

    WashingMachine(int detergentInMl) {
        detergentHolderDispenser = new DetergentHolderDispenser(detergentInMl);
    }

    public void start() {
        detergentHolderDispenser.dispenseDetergent();
        WashAction.wash();
        RinseAction.rinse();
        SpinAction.spin();
        System.out.println("done..");
    }
}

// start of client code
public class FacadeExample {
    public static void main(String[] args) throws java.lang.Exception {
        WashingMachine washingMachine = new WashingMachine(10);
        washingMachine.start();
    }
}
// end of client code

// OUTPUT
// Dispensing detergent of 10 ml.
// washing clothes
// rinsing clothes
// spinning to remove excess water
// done..