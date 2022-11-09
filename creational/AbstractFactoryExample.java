package abstractFactory;

import java.util.*;

/**
 * 
 * PROBLEM: Build a furniture assembling application that creates a chair type
 * by getting raw materials and assemling with an expert.
 * 
 * SOLUTION:
 * 
 * Product interface - declares product class methods(Chair, MaterialExpert)
 * Concrete product class - defines product methods
 * Factory interface - declares the abstract methods for each factory class
 * Concrete factory class - creates concrete product objects for each
 * flavour(Wood factory, Plastic factory)
 */

// ProductA interface
interface Chair {
    public void getRawMaterials();
}

// Concrete productA class 1
class WoodenChair implements Chair {
    public void getRawMaterials() {
        System.out.println("wooden chair materials arrived!!");
    }
}

// Concrete productA class 2
class PlasticChair implements Chair {
    public void getRawMaterials() {
        System.out.println("plastic chair materials arrived!!");
    }
}

// ProductB interface
interface MaterialExpert {
    public void assemble();
}

// Concrete productB class 1
class WoodenMaterialExpert implements MaterialExpert {
    public void assemble() {
        System.out.println("wood expert has completed the assembling!!");
    }
}

// Concrete productB class 2
class PlasticMaterialExpert implements MaterialExpert {
    public void assemble() {
        System.out.println("plastic expert has completed the assembling!!");
    }
}

/**
 * Abstract factory that knows all the abstract classes
 */
interface ChairFactory {
    public Chair getChair();

    public MaterialExpert getMaterialExpert();
}

// Concrete factory 1
class WoodenChairFactory implements ChairFactory {
    public Chair getChair() {
        return new WoodenChair();
    }

    public MaterialExpert getMaterialExpert() {
        return new WoodenMaterialExpert();
    }
}

// Concrete factory 2
class PlasticChairFactory implements ChairFactory {
    public Chair getChair() {
        return new PlasticChair();
    }

    public MaterialExpert getMaterialExpert() {
        return new PlasticMaterialExpert();
    }
}

// start of client code
class Application {
    private Chair chair;
    private MaterialExpert materialExpert;

    public Application(ChairFactory factory) {
        chair = factory.getChair();
        materialExpert = factory.getMaterialExpert();
    }

    public void assembleChairWithMaterialExpert() {
        chair.getRawMaterials();
        materialExpert.assemble();
    }
}

public class AbstractFactoryExample {
    public static void main(String[] args) throws java.lang.Exception {
        System.out.println("Enter wood/plastic.. ");
        Scanner reader = new Scanner(System.in);
        String input = reader.next();
        reader.close();

        Application app;
        ChairFactory factory;
        /**
         * wood
         * Factory type is decided during run time
         */
        if (input.equals("wood")) {
            factory = new WoodenChairFactory();
        } else {
            factory = new PlasticChairFactory();
        }
        app = new Application(factory);

        // generic method of the class
        app.assembleChairWithMaterialExpert();
    }
}
// end of client code

// OUTPUT
// Enter wood/plastic..
// wood
// wooden chair materials arrived!!
// wood expert has completed the assembling!!
