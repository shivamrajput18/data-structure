
// Problem Statement: Implement a round-robin CPU scheduling algorithm using a circular linked list. Each node will represent a process and contain Process ID, Burst Time, and Priority. Implement the following functionalities:
// Add a new process at the end of the circular list.
// Remove a process by Process ID after its execution.
// Simulate the scheduling of processes in a round-robin manner with a fixed time quantum.
// Display the list of processes in the circular queue after each round.
// Calculate and display the average waiting time and turn-around time for all processes.

import java.util.ArrayList;
import java.util.List;

class Process {
    int processID;
    int burstTime;
    int priority,remainingTime, waitingTime, turnaroundTime, completionTime;
    Process next;

    // Constructor
    public Process(int processID, int burstTime, int priority) {
        this.processID = processID;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class SchedulerProcess {
    Process head;
    int timeQuantum;
    Process current;
    int totalProcesses =0;

    List<Process> completedProcesses = new ArrayList<>();

    SchedulerProcess(int n) {
        this.timeQuantum = n;
    }

    public void addProcess(int processID, int burstTime, int priority) {
        Process newProcess = new Process(processID, burstTime, priority);
        totalProcesses++;
        if (head == null) {
            head = newProcess;
            newProcess.next = head;
            current = head;
        } else {
            Process temp = head;
            while (temp.next != current) {
                temp = temp.next;
            }
            temp.next = newProcess;
            newProcess.next = head;
        }

    }

    public void display() {
        Process temp = head;
        if (temp != null) {

            System.out.println("Process ID: " + temp.processID + " | Burst Time: " + temp.burstTime + " | Priority: "
                    + temp.priority);
            temp = temp.next;
        }
        while (temp != head) {
            System.out.println("Process ID: " + temp.processID + " | Burst Time: " + temp.burstTime + " | Priority: "
                    + temp.priority);
            temp = temp.next;
        }
        System.out.println();
    }

    public void removeProcess(int processID) {
        if (head == null)
            return;

        // if head to be removed
        if (head.processID == processID) {
            Process temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            if (head.next == head) { // for only one process
                head = null;
            } else {
                head = head.next;
                temp.next = head;
            }
            return;
        }

        // Find the process and remove
        Process current = head;
        Process prev = null;

        while (current.processID != processID && current.next != head) {
            prev = current;
            current = current.next;
        }

        prev.next = current.next;

    }

    public void executeRoundRobin() {
        if (head == null) {
            System.out.println("No processes to schedule!");
            return;
        }

        int timeElapsed = 0;
        Process temp = head;

        while (head != null) {
            System.out.println("\nExecuting Process ID: " + temp.processID);
            
            if (temp.remainingTime > timeQuantum) {
                temp.remainingTime -= timeQuantum;
                timeElapsed += timeQuantum;
                System.out.println("Process ID: " + temp.processID + " executed for " + timeQuantum + " units. Remaining Time: " + temp.remainingTime);
            } else {
                timeElapsed += temp.remainingTime;
                temp.remainingTime = 0;
                temp.completionTime = timeElapsed;
                temp.turnaroundTime = temp.completionTime; // Since Arrival Time is 0
                temp.waitingTime = temp.turnaroundTime - temp.burstTime;

                System.out.println("Process ID: " + temp.processID + " completed execution. Completion Time: " + temp.completionTime);
                
                completedProcesses.add(temp); // Store completed process data
                removeProcess(temp.processID);
            }

            if (head == null) break;
            temp = temp.next;
        }
        
        calculateAverageTimes();
    }

    public void calculateAverageTimes() {
        int totalWT = 0, totalTAT = 0;
        System.out.println("\nProcess Execution Summary:");
        System.out.println("Process ID | Burst Time | Completion Time | Turnaround Time | Waiting Time");

        for (Process p : completedProcesses) {
            totalWT += p.waitingTime;
            totalTAT += p.turnaroundTime;

            System.out.println(p.processID + "         | " + p.burstTime + "         | " + p.completionTime + "                | " + p.turnaroundTime + "                | " + p.waitingTime);
        }

        double avgWT = (double) totalWT / totalProcesses;
        double avgTAT = (double) totalTAT / totalProcesses;

        System.out.println("\nAverage Waiting Time: " + avgWT);
        System.out.println("Average Turnaround Time: " + avgTAT);
    } 

}

public class RoundRobin {
    public static void main(String[] args) {
        SchedulerProcess s1 = new SchedulerProcess(4); // Set Time Quantum = 4

        // Add processes
        s1.addProcess(1, 10, 2);
        s1.addProcess(2, 4, 1);
        s1.addProcess(3, 7, 3);
        s1.addProcess(4, 2, 1);
        System.out.println("Initial Process Queue:");

        // Display initial process queue
        // s1.display();

        // s1.removeProcess(1);
        s1.executeRoundRobin();
        s1.display();
    }
}