package memento;

/**
 * PROBLEM: Build a text editor application with enter, backup and restore
 * backedup text functionality.
 * 
 * SOLUTION:
 * 
 * Originator class - text editor class that triggers snapshot creation, backup,
 * restore action on demand
 * Memento class - creates the snapshot and restores the snapshot
 * Caretaker class - knows which snapshot to backup/restore.
 */

// Originator class
class TextEditor {
    public String text;
    Command command;

    TextEditor() {
        command = new Command();
    }

    public void setText(String text) {
        this.text = text;
    }

    public void backup() {
        command.backup(new Snapshot(this));
    }

    public void restore() {
        command.restore();
    }

    public void displayText() {
        System.out.println("Current editor text: " + text);
    }
}

// Memento class
class Snapshot {
    TextEditor textEditor;
    String text;

    Snapshot(TextEditor textEditor) {
        this.textEditor = textEditor;
        this.text = textEditor.text;
    }

    public void restoreSnapShot() {
        textEditor.text = this.text;
        System.out.println("restored");
    }
}

// Caretaker class
class Command {
    Snapshot backupSnapshot;

    public void backup(Snapshot snapshot) {
        backupSnapshot = snapshot;
        System.out.println("backed up");
    }

    public void restore() {
        if (backupSnapshot != null)
            backupSnapshot.restoreSnapShot();
        backupSnapshot = null;
    }
}

// start of client code
public class MementoExample {
    public static void main(String[] args) throws java.lang.Exception {
        TextEditor textEditor = new TextEditor();

        textEditor.setText("1234");
        textEditor.displayText();

        textEditor.backup();

        textEditor.setText("2345");
        textEditor.displayText();
        textEditor.setText("3456");
        textEditor.displayText();

        textEditor.restore();
        textEditor.displayText();
    }
}
// end of client code

// OUTPUT
// Current editor text: 1234
// backed up
// Current editor text: 2345
// Current editor text: 3456
// restored
// Current editor text: 1234