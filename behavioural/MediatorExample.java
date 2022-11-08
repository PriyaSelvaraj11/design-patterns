package mediator;

/**
 * Problem: Build a airport control tower application which 
 * manages the communication between all the planes.
 * 
 * Naive solution: Plane objects communicating with each other directly.
 * 
 * Solution with Design pattern: Build a control tower class that receives and displays the messages 
 * from the plane objects in a common portal visible to all planes.
 * 
 * Plane class - sends message to mediator class for communication
 * Mediator class - displays message ina common board
 * Client code - creates the control tower and various planes and manipulates them
 */


class Plane {
    String name;
    Plane(String name) {
        this.name = name;
    }
    public void communicateCurrentPosition(ControlTower controlTower) {
        controlTower.displayMessage(this, "nearing the tower");
    }
}

// mediator class 
class ControlTower {
    public void displayMessage(Plane plane, String message) {
        System.out.println("Plane name: " + plane.name + " message: "+ message);
    }
}

// start of client code
public class MediatorExample {
    public static void main(String[] args) {
        ControlTower controlTower = new ControlTower();

        Plane planeA = new Plane("planeA");
        Plane planeB = new Plane("planeB");
        Plane planeC = new Plane("planeC");

        planeA.communicateCurrentPosition(controlTower);
        planeB.communicateCurrentPosition(controlTower);
        planeC.communicateCurrentPosition(controlTower);
    }
}


// OUTPUT:
// Plane name: planeA message: nearing the tower
// Plane name: planeB message: nearing the tower
// Plane name: planeC message: nearing the tower
