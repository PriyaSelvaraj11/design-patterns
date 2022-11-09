package state;

/**
 * PROBLEM: Build a drink dispenser machine with following functionality
 * 1. insert coin
 * 1. dispenses drink when coin is inserted
 * 2. ejects the coin before dispensing the drink.
 * 
 * NAIVE SOLUTION: Adding different methods for each action
 * with "if..else" condition checks
 * on each state(coin inserted/coin not inserted/drink dispensed)
 * 
 * SOLUTION with Design pattern: Define each state as a class
 * 
 * State interface - declares all the actions which state has to define
 * Concrete state class - defines the action to be performed by the machine on
 * respective state
 * Drink dispenser context class - store reference of all state and
 * - delegates state calls
 * - exposes change state method
 * - used by client
 * Client code - creates and uses the context object
 */

// common interface for all states
interface State {
    public void insertCoin();

    public void ejectCoin();

    public void confirmDispense();

    public void dispenseDrink();
}

// concrete state 1
class CoinInserted implements State {
    DrinkDispenserMachine machine;

    CoinInserted(DrinkDispenserMachine machine) {
        this.machine = machine;
    }

    public void insertCoin() {
        System.out.println("Coin already inserted! Can't insert another!");
    }

    public void ejectCoin() {
        State state = machine.getNoCoinInsertedState();
        machine.changeState(state);
        System.out.println("Coin ejected!");
    }

    public void confirmDispense() {
        System.out.println("Drink dispense confirmed");
    }

    public void dispenseDrink() {
        State state = machine.getNoCoinInsertedState();
        machine.changeState(state);
        System.out.println("Drink dispensed...");
    }
}

// concrete state 2
class NoCoinInserted implements State {
    DrinkDispenserMachine machine;

    NoCoinInserted(DrinkDispenserMachine machine) {
        this.machine = machine;
    }

    public void insertCoin() {
        State state = machine.getCoinInsertedState();
        machine.changeState(state);
        System.out.println("Coin inserted successfully!!");
    }

    public void ejectCoin() {
        System.out.println("No coin to eject!");
    }

    public void confirmDispense() {
        System.out.println("Drink dispense failed");
    }

    public void dispenseDrink() {
        System.out.println("Insert coin to dispense drink!!");
    }
}

//
class DrinkDispenserMachine {
    State coinInserted;
    State noCoinInserted;
    State currentState;

    DrinkDispenserMachine() {
        coinInserted = new CoinInserted(this);
        noCoinInserted = new NoCoinInserted(this);

        currentState = noCoinInserted;
    }

    public void changeState(State s) {
        this.currentState = s;
    }

    public State getCoinInsertedState() {
        return coinInserted;
    }

    public State getNoCoinInsertedState() {
        return noCoinInserted;
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void ejectCoin() {
        currentState.ejectCoin();
    }

    public void dispenseDrink() {
        currentState.confirmDispense();
        currentState.dispenseDrink();
    }
}

// start of client code
public class StateExample {
    public static void main(String[] args) {
        DrinkDispenserMachine dispenseMachine = new DrinkDispenserMachine();
        dispenseMachine.insertCoin();
        dispenseMachine.insertCoin();
        dispenseMachine.ejectCoin();

        dispenseMachine.insertCoin();
        dispenseMachine.dispenseDrink();
    }
}
// end of client code

// OUTPUT
// Coin inserted successfully!!
// Coin already inserted! Can't insert another!
// Coin ejected!
// Coin inserted successfully!!
// Drink dispense confirmed
// Drink dispensed...