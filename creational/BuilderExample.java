package builder;

import java.util.*;

enum CakeShape {
    ROUND, SQUARE, RECTANGLE
}

enum CakeFlavour {
    CHOCOLATE, VANILLA, STRAWBERRY
}

class Cake {
    protected CakeShape shape;
    protected CakeFlavour flavour;
    protected List<String> toppings;

    Cake(CakeShape shape, CakeFlavour flavour) {
        this.shape = shape;
        this.flavour = flavour;
    }

    void addToppings(List<String> toppings) {
        this.toppings = toppings;
    }

    void bake() {
        System.out.println("Preparing " + this.shape + " " + this.flavour + " cake");
        System.out.println("Adding toppings: ");
        for (String topping : this.toppings) {
            System.out.println("   " + topping);
        }
        System.out.println("Cake ready to be served!!");
    }
}

/**
 * The builder patterns is used when construction of a object has
 * multiple steps and it is complex. It is also used to avoid
 * "telescoping constructor"
 **/

class CakeBuilder {
    protected CakeShape shape;
    protected CakeFlavour flavour;
    protected List<String> toppings;

    CakeBuilder() {
        toppings = new ArrayList<String>();
    }

    public CakeBuilder setShape(CakeShape shape) {
        this.shape = shape;
        return this;
    }

    public CakeBuilder setFlavour(CakeFlavour flavour) {
        this.flavour = flavour;
        return this;
    }

    public CakeBuilder addKitKat() {
        this.toppings.add("kitkat");
        return this;
    }

    public CakeBuilder addTimTams() {
        this.toppings.add("timtams");
        return this;
    }

    public CakeBuilder addOreos() {
        this.toppings.add("oreos");
        return this;
    }

    public CakeBuilder addChocFlakes() {
        this.toppings.add("chocflakes");
        return this;
    }

    public Cake build() {
        Cake cake = new Cake(this.shape, this.flavour);
        cake.addToppings(this.toppings);
        return cake;
    }
}

// start of client code
public class BuilderExample {
    public static void main(String[] args) throws java.lang.Exception {
        CakeBuilder cakeBuilder = new CakeBuilder();
        Cake cake = cakeBuilder.setShape(CakeShape.ROUND).setFlavour(CakeFlavour.VANILLA).addKitKat().build();
        cake.bake();
    }
}
// end of client code