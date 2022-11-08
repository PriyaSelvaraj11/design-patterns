package strategy;

/**
 * Problem : Build a order creation and payment application which accepts
 * credit or debit card as mode of payments.
 * 
 * Naive solution: Add all the modes of payments in the main Order class
 * 
 * Design pattern solution: Define each strategy as a class and 
 * pass the required payment mode object to order class
 * 
 * Strategy interface - declares methods that each strategy should define
 * Concrete strategy class - declares methods that context class uses to execute a strategy
 * Order Context class - maintains one reference to concrete strategy class
 *                       and invokes it when needed
 * Client - create a strategy object and pass to order object.
 */

// common interface for all strategy class
interface PaymentStrategy {
    public void pay(int amount);
}

// concrete strategy class 1
class PayByDebitCard implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("amount to be paid: "+ amount);
        System.out.println("getting debit card details and processing verification...");
        System.out.println("payment verified with debit card");
        System.out.println("----");
    }
}

// concrete strategy class 2
class PayByCreditCard implements PaymentStrategy{
    public void pay(int amount) {
        System.out.println("amount to be paid: "+ amount);
        System.out.println("getting credit card details and processing verification...");
        System.out.println("payment verified with credit card");
        System.out.println("----");
    }
}

// Order context class
class Order {
    int amount;
    Order(int amount) {
        this.amount = amount;
    }
    public void processOrder(PaymentStrategy strategy) {
        strategy.pay(this.amount);
    }
}

// start of client code
public class StrategyExample {
    public static void main(String[] args) {
        Order order1 = new Order(100);
        order1.processOrder(new PayByDebitCard());

        Order order2 = new Order(200);
        order2.processOrder(new PayByCreditCard());
    }
}
// end of client code


// OUTPUT
// amount to be paid: 100
// getting debit card details and processing verification...
// payment verified with debit card
// ----
// amount to be paid: 200
// getting credit card details and processing verification...
// payment verified with credit card
// ----