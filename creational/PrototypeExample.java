package prototype;

enum CakeShape {
    ROUND, SQUARE, RECTANGLE
}

enum CakeFlavour {
    CHOCOLATE, VANILLA, STRAWBERRY
}

// class using Cloneable interface
class Cake implements Cloneable {
    protected CakeShape shape;
    protected CakeFlavour flavour;
    protected boolean chocToppings = false;

    public void setShape(CakeShape shape) {
        this.shape = shape;
    }

    public void setFlavour(CakeFlavour flavour) {
        this.flavour = flavour;
    }

    public void addChocToppings() {
        this.chocToppings = true;
    }

    void bake() {
        System.out.println("Preparing " + this.shape + " " + this.flavour + " cake");
        if (this.chocToppings) {
            System.out.println("adding choc toppings...");
        }
        System.out.println("Cake ready to be served!!");
        System.out.println("__________");
    }

    Cake getClone() throws CloneNotSupportedException {
        return (Cake) this.clone();
    }
}

// class without using Cloneable interface
class CupCake {
    public CakeShape shape;
    public CakeFlavour flavour;
    public boolean chocToppings = false;

    public CupCake() {

    }

    public CupCake(CupCake cupCake) {
        this.shape = cupCake.shape;
        this.flavour = cupCake.flavour;
        this.chocToppings = cupCake.chocToppings;
    }

    public void setShape(CakeShape shape) {
        this.shape = shape;
    }

    public void setFlavour(CakeFlavour flavour) {
        this.flavour = flavour;
    }

    public void addChocToppings() {
        this.chocToppings = true;
    }

    void bake() {
        System.out.println("Preparing " + this.shape + " " + this.flavour + " cup cake");
        if (this.chocToppings) {
            System.out.println("adding choc toppings...");
        }
        System.out.println("Cake ready to be served!!");
        System.out.println("__________");
    }

    CupCake getClone() {
        return new CupCake(this);
    }
}

// start of client code
public class PrototypeExample {
    public static void main(String[] args) throws java.lang.Exception {
        // cake clone example
        Cake roundCake1 = new Cake();
        roundCake1.setShape(CakeShape.ROUND);
        roundCake1.setFlavour(CakeFlavour.VANILLA);

        Cake roundCake2 = roundCake1.getClone();
        roundCake2.addChocToppings();

        roundCake1.bake();
        roundCake2.bake();

        // cupcake clone example
        CupCake cupCake1 = new CupCake();
        cupCake1.setShape(CakeShape.ROUND);
        cupCake1.setFlavour(CakeFlavour.VANILLA);

        CupCake cupCake2 = cupCake1.getClone();
        cupCake2.addChocToppings();

        cupCake1.bake();
        cupCake2.bake();
    }
}
// end of client code

// OUTPUT
// Preparing ROUND VANILLA cake
// Cake ready to be served!!
// __________
// Preparing ROUND VANILLA cake
// adding choc toppings...
// Cake ready to be served!!
// __________
// Preparing ROUND VANILLA cup cake
// Cake ready to be served!!
// __________
// Preparing ROUND VANILLA cup cake
// adding choc toppings...
// Cake ready to be served!!
// __________