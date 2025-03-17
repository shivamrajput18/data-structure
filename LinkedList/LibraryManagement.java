
// Problem Statement: Design a library management system using a doubly linked list. Each node represents a book and contains the following attributes: Book Title, Author, Genre, Book ID, and Availability Status. Implement the following functionalities:
// Add a new book at the beginning, end, or at a specific position.
// Remove a book by Book ID.
// Search for a book by Book Title or Author.
// Update a book’s Availability Status.
// Display all books in forward and reverse order.
// Count the total number of books in the library.


class Node {
    String bookTitle;
    String author;
    String genre;
    int bookID;
    boolean availability;
    Node next;
    Node prev;
    
    Node(String bookTitle, String author, String genre, int bookID, boolean availability) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.genre = genre;
        this.bookID = bookID;
        this.availability = availability;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    Node head;
    Node tail;
    
    public void addBook(String bookTitle, String author, String genre, int bookID, boolean availability) {
        Node newnode = new Node(bookTitle, author, genre, bookID, availability);
        if (head == null) {
            head = newnode;
            tail = newnode;
        } else {
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
        }
    }
    
    public void displayBooks() {
        Node temp = head;
        while (temp != null) {
            System.out.print("Book Title: " + temp.bookTitle + " Author: " + temp.author + " Genre: " + temp.genre + " Book ID: " + temp.bookID + " Availability: " + temp.availability + "\n");
            temp = temp.next;
        }
        System.out.println();
    }
    
    public void addBookAtBeginning(String bookTitle, String author, String genre, int bookID, boolean availability) {
        Node newnode = new Node(bookTitle, author, genre, bookID, availability);
        newnode.next = head;
        head.prev = newnode;
        head = newnode;
    }
    
    public void addBookAtEnd(String bookTitle, String author, String genre, int bookID, boolean availability) {
        addBook(bookTitle, author, genre, bookID, availability);
    }
    
    public void removeBook(int bookID) {
        Node temp = head;
        while (temp != null) {
            if (temp.bookID == bookID) {
                if (temp == head) {
                    head = temp.next;
                    head.prev = null;
                } else if (temp == tail) {
                    tail = temp.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                break;
            }
            temp = temp.next;
        }
    }
    
    public void searchBookByTitle(String bookTitle) {
        Node temp = head;
        while (temp != null) {
            if (temp.bookTitle.equals(bookTitle)) {
                System.out.print("Book Title: " + temp.bookTitle + " Author: " + temp.author + " Genre: " + temp.genre + " Book ID: " + temp.bookID + " Availability: " + temp.availability + "\n");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public void updateAvailability(int bookID, boolean availability) {
        Node temp = head;
        while (temp != null) {
            if (temp.bookID == bookID) {
                temp.availability = availability;
                break;
            }
            temp = temp.next;
        }
    }

    public void displayReverse(){
        Node temp = head;

        while(temp.next!=null){
            temp = temp.next;
        }

        while(temp!=null){
            System.out.print("Book Title: " + temp.bookTitle + " Author: " + temp.author + " Genre: " + temp.genre + " Book ID: " + temp.bookID + " Availability: " + temp.availability + "\n");
            temp = temp.prev;
        }

    }

    public int countBooks(){
        Node temp = head;
        int count = 0;
        while(temp!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
}


public class LibraryManagement {
    public static void main(String[] args) {
        Library l1 = new Library();
        l1.addBook("Book1", "Author1", "Genre1", 1, true);
        l1.addBook("Book2", "Author2", "Genre2", 2, false);
        l1.addBook("Book3", "Author3", "Genre3", 3, true);
        l1.displayBooks();
        l1.displayReverse();
        System.out.println(l1.countBooks());
    }
}