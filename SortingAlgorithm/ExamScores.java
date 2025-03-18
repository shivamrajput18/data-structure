//sort using selection sort

import java.util.Arrays;

public class ExamScores {

    public static void swap(int[] marks, int i ,int j){
         int temp = marks[i];
         marks[i] = marks[j];
         marks[j] = temp;
    }
    public static void bubbleSort(int[] marks) {
        int n = marks.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndx = i;
            for (int j = i+1 ; j < n ; j++) {
                if (marks[j] < marks[minIndx]) {
                    minIndx = j;
                }
            }
           
            swap(marks,minIndx,i);
        }
    }

    public static void printMarks(int[] marks) {
        System.out.println(Arrays.toString(marks));
    }

    public static void main(String[] args) {
        int[] marks = {85, 92, 75, 60, 90, 88, 76};

        System.out.print("Original Exam Marks: ");
        printMarks(marks);

        bubbleSort(marks);

        System.out.print("Sorted Exam Marks: ");
        printMarks(marks);
    }
}
