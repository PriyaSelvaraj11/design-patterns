package iterator;

import java.util.*;

/**
 * PROBLEM - There exists an application consisting of mobile and earphone
 * company classes. Mobile company class stores the products as simple array.
 * Earphone company stores the products as List. Add a new gagdet retailer class
 * that prints all the products of mobile and earphone company.
 * 
 * NAIVE SOLUTION: Iterate through the mobile and earphone company products with
 * array/List if..else check.
 * 
 * DESIGN PATTERN BASED SOLUTION: Add iterator for Mobile and earphone company
 * class so that gadget retailer class can treat both iteration in a common way
 * with getNext() and hasNext() methods.
 * 
 * Iterator interface - declares methods needed for traversal
 * Concrete iterator - defines traversal methods.
 * Client class - traverses the iterator objects.
 */

// Product class
class Product {
    public String name;

    Product(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("name: " + name);
    }
}

// Iterator interface
interface ProductIterator {
    public boolean hasNext();

    public Product getNext();
}

interface ProductCompany extends ProductIterator {

}

// Concrete iterator collection class 1
class EarphoneCompany implements ProductCompany {
    List<Product> earphones = new ArrayList<Product>();

    private int currentPosition = 0;

    EarphoneCompany() {
        for (int i = 1; i <= 3; i++) {
            earphones.add(new Product("earphone " + i));
        }
    }

    public boolean hasNext() {
        return currentPosition < earphones.size();
    }

    public Product getNext() {
        if (!hasNext()) {
            return null;
        }

        Product earphone = earphones.get(currentPosition);
        currentPosition++;
        return earphone;
    }
}

// Concrete iterator collection class 1
class MobileCompany implements ProductCompany {
    Product[] mobiles = new Product[3];
    private int currentPosition = 0;

    MobileCompany() {
        for (int i = 1; i <= 3; i++) {
            mobiles[i - 1] = new Product("mobile " + i);
        }
    }

    public boolean hasNext() {
        return currentPosition < mobiles.length;
    }

    public Product getNext() {
        if (!hasNext()) {
            return null;
        }

        Product earphone = mobiles[currentPosition];
        currentPosition++;
        return earphone;
    }

}

// Client class
class GadgetRetailer {
    List<ProductCompany> companies = new ArrayList<>();

    GadgetRetailer() {
        MobileCompany mobileCompany = new MobileCompany();
        EarphoneCompany earphoneCompany = new EarphoneCompany();
        companies.add(mobileCompany);
        companies.add(earphoneCompany);
    }

    public void printAllProducts() {
        for (ProductCompany company : companies) {
            printCompanyProduct(company);
        }
    }

    public void printCompanyProduct(ProductCompany company) {
        while (company.hasNext()) {
            Product product = company.getNext();
            System.out.println(product.name);
        }
        System.out.println("----");
    }

}

public class IteratorExample {
    public static void main(String[] args) throws java.lang.Exception {
        GadgetRetailer gadgetRetailer = new GadgetRetailer();
        gadgetRetailer.printAllProducts();
    }
}

// OUTPUT
// mobile 1
// mobile 2
// mobile 3
// ----
// earphone 1
// earphone 2
// earphone 3
// ----