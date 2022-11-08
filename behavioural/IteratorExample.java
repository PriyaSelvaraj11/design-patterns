package iterator;

import java.util.*;

class Product {
    public String name;

    Product(String name) {
        this.name = name;
    }

    public void display() {
        System.out.println("name: " + name);
    }
}

interface ProductIterator {
    public boolean hasNext();

    public Product getNext();
}

interface ProductCompany extends ProductIterator {

}

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