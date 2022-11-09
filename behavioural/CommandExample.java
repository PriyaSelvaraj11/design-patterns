package command;

/**
 * PROBLEM: Build a application which supports save and close actions.
 * The actions can be invoked in different ways -
 * by pressing a button or by shortcut keys in keyboard
 * 
 * SOLUTION: Build Save and Close actions as command classes
 * 
 * Command interface - declares what each concrete command should implement
 * Contrete command class - defines the respective command action
 * Invoker class - Gets the command class as input and executes when needed
 * Client code - creates the invoker objects and concrete command objects and
 * manipulates them
 */

// common interface for all commands
interface Command {
    public void execute();
}

// concrete command class 1
class SaveCommand implements Command {
    public void execute() {
        System.out.println("save command executing..");
    }
}

// concrete command class 2
class CloseCommand implements Command {
    public void execute() {
        System.out.println("close command executing..");
    }
}

// Invoker class 1
class Button {
    String name;
    Command command;

    Button(String name, Command cmd) {
        this.name = name;
        this.command = cmd;
    }

    public void press() {
        command.execute();
    }
}

// Invoker class 2
class Shortcut {
    String name;
    Command command;

    Shortcut(String name, Command cmd) {
        this.name = name;
        this.command = cmd;
    }

    public void invoke() {
        command.execute();
    }
}

// start of client code
public class CommandExample {
    public static void main(String[] args) {
        Command closeCommand = new CloseCommand();
        Command saveCommand = new SaveCommand();

        Button saveButton = new Button("save", saveCommand);
        Button closeButton = new Button("close", closeCommand);

        Shortcut saveShortcut = new Shortcut("saveShortcut", saveCommand);
        Shortcut closeShortcut = new Shortcut("closeShortcut", closeCommand);

        saveButton.press();
        closeButton.press();

        saveShortcut.invoke();
        closeShortcut.invoke();
    }
}
// end of client code

// OUTPUT:
// save command executing..
// close command executing..
// save command executing..
// close command executing..