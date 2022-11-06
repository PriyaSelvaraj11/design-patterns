import java.util.*;
import java.lang.*;
import java.io.*;

class Plane {
    String name;
    Plane(String name) {
        this.name = name;
    }
    public void communicateCurrentPosition(ControlTower controlTower) {
        controlTower.displayMessage(this, "nearing the tower");
    }
}

class ControlTower {
    public void displayMessage(Plane plane, String message) {
        System.out.println("Plane name: " + plane.name + " message: "+ message);
    }
}

// start of client code
public class Main {
    public static void main(String[] args) {
        ControlTower controlTower = new ControlTower();

        Plane planeA = new Plane("planeA");
        Plane planeB = new Plane("planeB");

        planeA.communicateCurrentPosition(controlTower);
        planeB.communicateCurrentPosition(controlTower);
    }
}


// OUTPUT:
// Plane name: planeA message: nearing the tower
// Plane name: planeB message: nearing the tower