import java.util.*;
import java.lang.*;
import java.io.*;

interface Product {
    public String getDescription();
    public int getPrice();
}

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

// composite class which can hold multiple products and act as product class
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

class Earphone extends BaseProduct {
    Earphone(int price) {
        super(price);
        this.description = "earphone";
    }
}

class Mobile extends BaseProduct {
    Mobile(int price) {
        super(price);
        this.description = "mobile";
    }
}

class Landline extends BaseProduct {
    Landline(int price) {
        super(price);
        this.description = "landline";
    }
}

// start of client code
class Main {
    public static void main (String[] args) throws java.lang.Exception
	{
        // client treats base product and composite product getPrice() method in 
        // similar way
        Landline landline = new Landline(50);
        System.out.println("Landline price: "+ landline.getPrice());

        Mobile mobile = new Mobile(100);
        Earphone earphone = new Earphone(10);
        PackingBox packingBox =  new PackingBox(10);
        packingBox.addProduct(mobile);
        packingBox.addProduct(earphone);
        System.out.println("Packing box total price: "+ packingBox.getPrice());
        

		
    }
}
// end of client code