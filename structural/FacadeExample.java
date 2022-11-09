package facade;

/**
 * PROBLEM: Build a washing machine application which gets detergent, wash,
 * rinses and spins clothes.
 * 
 * NAIVE SOLUTION: The client method calls the list of action methods.
 * 
 * DESIGN PATTERN BASED SOLUTION: Facade method which calls the list of action methods
 * and simplified set of actions to the user.
 * 
 * Subsystem class - implements each minor level action
 * Facade class - knows how to manage various subsystems and exposes simplied
 * set of actions.
 */

// Subsystem class 1
class DetergentHolderDispenser {
    int detergentInMl;

    DetergentHolderDispenser(int detergentInMl) {
        this.detergentInMl = detergentInMl;
    }

    public void dispenseDetergent() {
        System.out.println("Dispensing detergent of " + detergentInMl + " ml.");
    }
}

// Subsystem class 2
class WashAction {
    public static void wash() {
        System.out.println("washing clothes");
    }
}

// Subsystem class 3
class RinseAction {
    public static void rinse() {
        System.out.println("rinsing clothes");
    }
}

// Subsystem class 4
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