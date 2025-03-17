class Node {
    String data;
    Node next;
    Node prev;

    Node(String data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class TextEditor {
    private Node head;
    private Node current;
    private int size;
    private final int HISTORY_LIMIT = 10;

    TextEditor() {
        head = new Node(""); // Initial empty state
        current = head;
        size = 1;
    }

    public void addState(String text) {
        Node newNode = new Node(text);

        // If undo has been performed, clear the redo history
        if (current.next != null) {
            current.next = null; // Remove redo states
        }

        // If we exceed history limit, remove oldest entry
        if (size == HISTORY_LIMIT) {
            head = head.next;
            head.prev = null;
            size--;  // Decrease size because we removed a state
        }

        // Append new state
        newNode.prev = current;
        current.next = newNode;
        current = newNode;
        size++;
    }

    public void undo() {
        if (current.prev != null) {
            System.out.println("Undo: " + current.data);
            current = current.prev;
        } else {
            System.out.println("Nothing to undo");
        }
    }

    public void redo() {
        if (current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.data);
        } else {
            System.out.println("Nothing to redo");
        }
    }

    public void display() {
        System.out.println("Current state: " + current.data);
    }
}

public class UndoRedo {
    public static void main(String[] args) {
        TextEditor myTextEditor = new TextEditor();
        
        // Adding states
        myTextEditor.addState("Hello");
        myTextEditor.addState("How are you?");
        myTextEditor.addState("This is a text editor.");

        // Undo actions
        myTextEditor.undo(); // Reverts to "How are you?"
        myTextEditor.undo(); // Reverts to "Hello"

        // Redo actions
        myTextEditor.redo(); // Goes back to "How are you?"
        myTextEditor.redo(); // Goes back to "This is a text editor."
        myTextEditor.redo(); // Nothing to redo

        // Display current state
        myTextEditor.display();

        // After undoing, add a new state (should clear redo history)
        myTextEditor.undo();
        myTextEditor.addState("New sentence added!");

        // Now redo should not work
        myTextEditor.redo(); // Nothing to redo

        myTextEditor.display();
    }
}
