package composite;

import java.util.*;

/**
 * PROBLEM: Build a gadget ordering system which contains different products
 * like landline, earphone, mobile and packing boxes.
 * The client can purchase one or more products in one order.
 * 
 * SOLUTION:
 * 
 * Component interface - product interface
 * Leaf class - implements component interface and cannot have
 * sub-components(landline, earphone, mobile)
 * Composite class - implements component interface and has sub-components
 * list.(packing box)
 */

// Component interface
interface Product {
    public String getDescription();

    public int getPrice();
}

// Component concrete class
class BaseProduct implements Product {
    protected int price;
    protected String description = "";

    BaseProduct(int price) {
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public int getPrice() {
        return this.price;
    }
}

// Composite class which can hold multiple products and act as product class
class PackingBox extends BaseProduct {
    protected List<Product> productList = new ArrayList<Product>();

    PackingBox(int price) {
        super(price);
        this.description = "earphone";
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public int getPrice() {
        int totalPrice = this.price;
        for (Product product : productList) {
            if (product.getPrice() != 0) {
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;
    }
}

// Leaf class 1
class Earphone extends BaseProduct {
    Earphone(int price) {
        super(price);
        this.description = "earphone";
    }
}

// Leaf class 2
class Mobile extends BaseProduct {
    Mobile(int price) {
        super(price);
        this.description = "mobile";
    }
}

// Leaf class 3
class Landline extends BaseProduct {
    Landline(int price) {
        super(price);
        this.description = "landline";
    }
}

// start of client code
public class CompositeExample {
    public static void main(String[] args) throws java.lang.Exception {
        // client treats base product and composite product getPrice() method in
        // similar way
        Landline landline = new Landline(50);
        System.out.println("Landline price: " + landline.getPrice());

        Mobile mobile = new Mobile(100);
        Earphone earphone = new Earphone(10);
        PackingBox packingBox = new PackingBox(10);
        packingBox.addProduct(mobile);
        packingBox.addProduct(earphone);
        System.out.println("Packing box total price: " + packingBox.getPrice());

    }
}
// end of client code

// OUTPUT
// Landline price: 50
// Packing box total price: 120