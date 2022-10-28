import java.util.*;
import java.lang.*;
import java.io.*;

interface Chair
{
    public int getNumberOfLegs();
    public float getHeight();
}

class PlasticChair implements Chair
{
    protected int numberOfLegs;
    protected float height;

    public PlasticChair(int numberOfLegs, float height)
    {
        this.numberOfLegs = (int)numberOfLegs;
        this.height = height;
    }

    public int getNumberOfLegs()
    {
        return this.numberOfLegs;
    }

    public float getHeight()
    {
        return this.height;
    }
}

/* Simple factory class which creates an instance 
* without exposing any instantiation logic to the caller
*/
class ChairFactory
{
    public static Chair makeChair(int numberOfLegs, float height)
    {
        return new PlasticChair(numberOfLegs, height);
    }
}


// start of client code 
class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Chair chair = ChairFactory.makeChair(3,4.5f);
		System.out.println(chair.getNumberOfLegs());
	}
}
// end of client code 
