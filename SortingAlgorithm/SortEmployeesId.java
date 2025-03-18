//using insertion sort

import java.util.Arrays;

public class SortEmployeesId {
    public static void insertionSort(int[] employeeIDs) {
        int n = employeeIDs.length;
        for (int i = 1; i < n; i++) {
            int key = employeeIDs[i];
            int j = i - 1;

            // Move elements of employeeIDs[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && employeeIDs[j] > key) {
                employeeIDs[j + 1] = employeeIDs[j];
                j--;
            }
            employeeIDs[j + 1] = key;
        }
    }

    public static void printIDs(int[] employeeIDs) {
        System.out.println(Arrays.toString(employeeIDs));
    }

    public static void main(String[] args) {
        int[] employeeIDs = {102, 110, 104, 101, 108, 105};

        System.out.print("Original Employee IDs: ");
        printIDs(employeeIDs);

        insertionSort(employeeIDs);

        System.out.print("Sorted Employee IDs: ");
        printIDs(employeeIDs);
    }
}
