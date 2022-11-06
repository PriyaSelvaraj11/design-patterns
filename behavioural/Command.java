import java.util.*;
import java.lang.*;
import java.io.*;

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

public class Main {
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

// OUTPUT:
// save command executing..
// close command executing..
// save command executing..
// close command executing..