//sort using bubble sort

import java.util.Arrays;

public class SortStudentMarks {
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    // Swap marks[j] and marks[j + 1]
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped in the inner loop, the array is sorted
            if (!swapped) {
                break;
            }
        }
    }

    public static void printMarks(int[] marks) {
        System.out.println(Arrays.toString(marks));
    }

    public static void main(String[] args) {
        int[] marks = {85, 92, 75, 60, 90, 88, 76};

        System.out.print("Original Marks: ");
        printMarks(marks);

        bubbleSort(marks);

        System.out.print("Sorted Marks: ");
        printMarks(marks);
    }
}
