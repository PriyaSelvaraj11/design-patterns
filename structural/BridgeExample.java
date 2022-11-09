package bridge;


/**
 * PROBLEM: Build a application which managed turning on and off the TV/Remote.
 * 
 * SOLUTION: Build a bridge class, namely remote, which gets device as input and triggers on/off methods when needed.
 * 
 * Abstraction class - remote class which triggers different functionality needed
 * Implementation interface - declares all the needed functionality methods
 * Concrete implementation class - defines the actual logic of the functionality.
 */

 // Implementation interface
interface Device {
    public boolean isEnabled();

    public void on();

    public void off();
}
//Concrete implementation class 1
class TV implements Device {
    protected boolean isEnabled = false;

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void on() {
        this.isEnabled = true;
        System.out.println("turning on the TV");
    }

    public void off() {
        this.isEnabled = false;
        System.out.println("turning off the TV");
    }
}
// Concrete implementation class 2
class Radio implements Device {
    protected boolean isEnabled = false;

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void on() {
        this.isEnabled = true;
        System.out.println("turning on the radio");
    }

    public void off() {
        this.isEnabled = false;
        System.out.println("turning off the radio");
    }
}

// abstraction class for the devices
class Remote {
    Device device;

    Remote(Device device) {
        this.device = device;
    }

    public void turnOn() {
        if (device.isEnabled()) {
            System.out.println("device is already on!");
        } else {
            device.on();
        }
    }

    public void turnOff() {
        if (!device.isEnabled()) {
            System.out.println("device is already off!");
        } else {
            device.off();
        }
    }
}

// start of client code
public class BridgeExample {
    public static void main(String[] args) throws java.lang.Exception {
        Remote tvRemote = new Remote(new TV());
        tvRemote.turnOn();
        tvRemote.turnOff();

        Remote radioRemote = new Remote(new Radio());
        radioRemote.turnOn();
        radioRemote.turnOff();

    }
}
// end of client code

// OUTPUT 
// turning on the TV
// turning off the TV
// turning on the radio
// turning off the radio