package abstractFactory;

import java.util.*;

interface Chair
{
    public void getRawMaterials();
}

class WoodenChair implements Chair
{
    public void getRawMaterials() {
        System.out.println("wooden chair materials arrived!!");
    }   
}

class PlasticChair implements Chair
{
    public void getRawMaterials() {
        System.out.println("plastic chair materials arrived!!");
    }   
}

interface MaterialExpert 
{ 
    public void assemble();
}

class WoodenMaterialExpert implements MaterialExpert {
    public void assemble() {
        System.out.println("wood expert has completed the assembling!!");
    }
}

class PlasticMaterialExpert implements MaterialExpert {
    public void assemble() {
        System.out.println("plastic expert has completed the assembling!!");
    }
}

/**
 * Abstract factory that knows all the abstract classes
 */
interface ChairFactory
{
    public Chair getChair();
    public MaterialExpert getMaterialExpert();
}


/**
 * Specific factory is responsible for creating
 * objects of specfic variety
 */
class WoodenChairFactory implements ChairFactory
{
    public Chair getChair()
    {
        return new WoodenChair();
    }

    public MaterialExpert getMaterialExpert()
    {
        return new WoodenMaterialExpert();
    }
}

class PlasticChairFactory implements ChairFactory
{
    public Chair getChair()
    {
        return new PlasticChair();
    }

    public MaterialExpert getMaterialExpert()
    {
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

public class AbstractFactoryExample
{
	public static void main (String[] args) throws java.lang.Exception
	{
        System.out.println("Enter wood/plastic.. ");
        Scanner reader = new Scanner(System.in); 
		String input = reader.next();
		reader.close();
		
        Application app;
        ChairFactory factory;
        /**wood
        * Factory type is decided during run time
        */
		if(input.equals("wood")) {
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
