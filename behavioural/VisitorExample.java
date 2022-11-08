/**
 * Problem : There is a existing application which deals with
 * building types - residential , office.
 *
 * Add a new functionality where to display the building details
 * without adding the functionality directly on the classes
 * 
 * Solution: Add a visitor class with a display method for each class
 * 
 * Concrete class - pre built class with a method to accept visitor
 * Visitor class - serveral versions of the display functionality based on
 * various building class
 */

// abstract class for all Building
abstract class Building {
    public String name;

    Building(String name) {
        this.name = name;
    }

    abstract void display(DisplayBuildingType displayBuildingType);
}

// concrete class 1
class Residential extends Building {
    int numberOfResidents;

    Residential(String name, int numberOfResidents) {
        super(name);
        this.numberOfResidents = numberOfResidents;
    }

    public void display(DisplayBuildingType displayBuildingType) {
        displayBuildingType.displayResidential(this);
    }
}

// concrete class 2

class Office extends Building {
    int numberOfWorkers;
    int numberOfFloors;

    Office(String name, int numberOfWorkers, int numberOfFloors) {
        super(name);
        this.numberOfWorkers = numberOfWorkers;
        this.numberOfFloors = numberOfFloors;
    }

    public void display(DisplayBuildingType displayBuildingType) {
        displayBuildingType.displayOffice(this);
    }
}

// Visitor class
class DisplayBuildingType {
    public void displayResidential(Residential residential) {
        System.out.println("Displaying residential type with");
        System.out.println("Name: " + residential.name);
        System.out.println("number Of residents: " + residential.numberOfResidents);
        System.out.println("----");
    }

    public void displayOffice(Office office) {
        System.out.println("Displaying office type with");
        System.out.println("Name: " + office.name);
        System.out.println("number Of Workers: " + office.numberOfWorkers);
        System.out.println("number Of Floors: " + office.numberOfFloors);
        System.out.println("----");
    }
}

// start of client code
public class VisitorExample {
    public static void main(String[] args) {
        Residential residential = new Residential("sweet home", 4);
        Office mechanicOffice = new Office("Mechanic office", 100, 4);

        DisplayBuildingType displayBuildingType = new DisplayBuildingType();
        residential.display(displayBuildingType);
        mechanicOffice.display(displayBuildingType);
    }
}
// end of client code

// OUTPUT
// Displaying residential type with
// Name: sweet home
// number Of residents: 4
// ----
// Displaying office type with
// Name: Mechanic office
// number Of Workers: 100
// number Of Floors: 4
// ----
