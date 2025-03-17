
class Task {
    int taskID;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    Task(int taskID, String taskName, int priority, String dueDate) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class Scheduler {
    Task head;
    Task current; // Pointer for cycling through tasks

    // Add task at the end (default)
    public void addTask(int taskID, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskID, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head; // Circular link
            current = head; // Initialize current pointer
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newTask;
            newTask.next = head; // Circular link
        }
    }

    // Add task at the beginning
    public void addTaskAtBeginning(int taskID, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskID, taskName, priority, dueDate);
        if (head == null) {
            head = newTask;
            newTask.next = head;
            current = head;
        } else {
            Task temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            newTask.next = head;
            temp.next = newTask;
            head = newTask; // Update head to the new Task
        }
    }

    // Add task at a specific position
    public void addTaskAtPosition(int position, int taskID, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskID, taskName, priority, dueDate);
        if (position == 1) {
            addTaskAtBeginning(taskID, taskName, priority, dueDate);
            return;
        }
        
        Task temp = head;
        int count = 1;
        while (temp.next != head && count < position - 1) {
            temp = temp.next;
            count++;
        }
        newTask.next = temp.next;
        temp.next = newTask;
    }

    // Remove a task by Task ID
    public void removeTask(int taskID) {
        if (head == null) {
            System.out.println("Task list is empty!");
            return;
        }

        Task temp = head, prev = null;

        // If head Task is the task to be deleted
        if (head.taskID == taskID) {
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = head.next;
            head = head.next;
            return;
        }

        // Search for the task
        Task curr = head;
        do {
            prev = curr;
            curr = curr.next;
            if (curr.taskID == taskID) {
                prev.next = curr.next;
                return;
            }
        } while (curr != head);
        
        System.out.println("Task ID " + taskID + " not found.");
    }

    // View current task and move to next
    public void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks available!");
            return;
        }
        System.out.println("Current Task -> ID: " + current.taskID + ", Name: " + current.taskName + ", Priority: " + current.priority + ", Due Date: " + current.dueDate);
        current = current.next; // Move to the next task in the circular list
    }

    // Search tasks by priority
    public void searchTaskByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks in the list!");
            return;
        }

        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println("Found Task -> ID: " + temp.taskID + ", Name: " + temp.taskName + ", Due Date: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks found with priority " + priority);
        }
    }

    // Display all tasks
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks in the list!");
            return;
        }

        Task temp = head;
        do {
            System.out.println("Task ID: " + temp.taskID + " Task Name: " + temp.taskName + " Priority: " + temp.priority + " Due Date: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        Scheduler scheduler = new Scheduler();
        
        // Adding tasks
        scheduler.addTask(1, "Task1", 1, "01-01-2022");
        scheduler.addTask(2, "Task2", 2, "02-01-2022");
        scheduler.addTask(3, "Task3", 3, "03-01-2022");

        // Display all tasks
        System.out.println("Task List:");
        scheduler.displayTasks();

        // Add at the beginning
        scheduler.addTaskAtBeginning(0, "Urgent Task", 0, "12-31-2021");
        
        // Add at a specific position
        scheduler.addTaskAtPosition(3, 4, "Mid Task", 2, "01-05-2022");

        System.out.println("\nAfter Adding Tasks:");
        scheduler.displayTasks();

        // Remove a task
        scheduler.removeTask(2);
        System.out.println("\nAfter Removing Task ID 2:");
        scheduler.displayTasks();

        // View and move to next task
        System.out.println("\nViewing Current Tasks:");
        scheduler.viewCurrentTask();
        scheduler.viewCurrentTask();
        
        // Search by priority
        System.out.println("\nSearching for Priority 2:");
        scheduler.searchTaskByPriority(2);
    }
}