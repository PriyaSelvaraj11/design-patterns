package template;

/**
 * PROBLEM : Build a application to construct houses with
 * wooden or glass windows and doors.
 * 
 * NAIVE SOLUTION: Two classes namely wooden and glass house with duplicate
 * buildBasement and buildWalls methods
 * 
 * DESIGN PATTERN BASED SOLUTION: Define a template(abstract class) for common steps
 * and define buildWindows and buildDoor in concrete classes.
 * 
 * Abstract template class - defines the common steps for building houses and
 * declares abstract steps.
 * Concrete class - overrides steps of base class if needed and
 * defines the abstract steps.
 * Client - calls the required concrete class
 */

// House template abstract class
abstract class BaseHouse {
    protected void buildBasement() {
        System.out.println("adding basement..");
    }

    protected void buildWalls() {
        System.out.println("building walls..");
    }

    abstract protected void buildWindows();

    abstract protected void buildDoor();

    void buildHouse() {
        buildBasement();
        buildWalls();
        buildWindows();
        buildDoor();
    }
}

// Concrete class 1
class WoodenHouse extends BaseHouse {
    protected void buildWindows() {
        System.out.println("building windows with WOOD..");
    }

    protected void buildDoor() {
        System.out.println("building doors with WOOD..");
    }
}

// Concrete class 2
class GlassHouse extends BaseHouse {
    protected void buildWindows() {
        System.out.println("building windows with GLASS..");
    }

    protected void buildDoor() {
        System.out.println("building doors with GLASS..");
    }
}

// start of client code
public class TemplateExample {
    public static void main(String[] args) {
        WoodenHouse woodhouse = new WoodenHouse();
        woodhouse.buildHouse();
        System.out.println("-----");
        GlassHouse glassHouse = new GlassHouse();
        glassHouse.buildHouse();
    }
}
// end of client code

// OUTPUT
// adding basement..
// building walls..
// building windows with WOOD..
// building doors with WOOD..
// -----
// adding basement..
// building walls..
// building windows with GLASS..
// building doors with GLASS..
