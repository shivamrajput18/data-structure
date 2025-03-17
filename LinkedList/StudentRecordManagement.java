// Problem Statement: Create a program to manage student records using a singly linked list. Each node will store information about a student, including their Roll Number, Name, Age, and Grade. Implement the following operations:
// Add a new student record at the beginning, end, or at a specific position.
// Delete a student record by Roll Number.
// Search for a student record by Roll Number.
// Display all student records.
// Update a student's grade based on their Roll Number.

class Node {
    int rollNumber;
    String name;
    int age;
    char grade;
    Node next;
 
    Node(int rollNumber, String name, int age, char grade) {
       this.rollNumber = rollNumber;
       this.name = name;
       this.age = age;
       this.grade = grade;
       this.next = null;
    }
 
 }
 
 class StudentRecord {
    Node head;
 
    public void addStudentRecord(int rollNumber, String name, int age, char grade) {
       Node newnode = new Node(rollNumber, name, age, grade);
       if (head == null) {
          head = newnode;
       } else {
          Node temp = head;
          while (temp.next != null) {
             temp = temp.next;
          }
          temp.next = newnode;
       }
    }
 
    public void displayStudent() {
       Node temp = head;
       while (temp != null) {
          System.out.print("Roll Number: " + temp.rollNumber + " Name: " + temp.name + "Age: " + temp.age + " Grage: "
                + temp.grade + "\n");
          temp = temp.next;
       }
       System.out.println();
    }
 
    public void addStudentRecordAtBeginning(int rollNumber, String name, int age, char grade) {
       Node newnode = new Node(rollNumber, name, age, grade);
       newnode.next = head;
       head = newnode;
    }
 
    public void addStudentRecordAtEnd(int rollNumber, String name, int age, char grade) {
       addStudentRecord(rollNumber, name, age, grade);
    }
 
    public void addStudentRecordAtPosition(int rollNumber, String name, int age, char grade, int position) {
 
       Node newnode = new Node(rollNumber, name, age, grade);
 
       if (position == 0) {
          addStudentRecordAtBeginning(rollNumber, name, age, grade);
       } else {
 
          Node temp = head;
          while (position != 1) {
             temp = temp.next;
             position--;
          }
          newnode.next = temp.next;
          temp.next = newnode;
       }
 
    }
 
    public void deleteStudentRecord(int rollNumber) {
       Node temp = head;
 
       while (temp.next != null && temp.next.rollNumber != rollNumber) {
          temp = temp.next;
       }
 
       if (temp != null && temp.next != null) {
 
          temp.next = temp.next.next;
       }
 
    }
 
    public void updateGrade(int rollNumber, char updatedGrade) {
       Node temp = head;
   
       while (temp != null && temp.rollNumber != rollNumber) {
           temp = temp.next;
       }
   
       
       if (temp != null) {
        
           temp.grade = updatedGrade;
       }
   }
   
 
 }
 
 public class StudentRecordManagement {
    public static void main(String[] args) {
       StudentRecord s1 = new StudentRecord();
       s1.addStudentRecord(1, "Shivam", 23, 'A');
       s1.addStudentRecord(2, "Ashu", 22, 'A');
       s1.addStudentRecord(3, "Rohan", 25, 'B');
       s1.displayStudent();
    
       
       s1.addStudentRecordAtPosition(55, "raj", 24, 'C', 2);
       s1.displayStudent();
      
       
       s1.deleteStudentRecord(3);
       s1.displayStudent();
       
       s1.addStudentRecord(32, "prakesh", 25, 'C');
       s1.displayStudent();
       
       s1.updateGrade(2, 'G');
       s1.displayStudent();
    }
 
 }