package bridge;

interface Device {
    public boolean isEnabled();

    public void on();

    public void off();
}

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
