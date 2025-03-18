// Using merge sort

import java.util.Arrays;

public class BookPrices {
    
    public static void merge(int[] bookprices, int start, int mid, int end) {
        int n1 = mid - start + 1;
        int n2 = end - mid;
        int left[] = new int[n1];
        int right[] = new int[n2];

        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            left[i] = bookprices[start + i];
        
        for (int j = 0; j < n2; ++j)
            right[j] = bookprices[mid + 1 + j];

        // Merging the arrays
        int i = 0, j = 0, k = start;  // Fixing k to start from 'start'
        
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                bookprices[k] = left[i];
                i++;
            } else {
                bookprices[k] = right[j];
                j++;
            }
            k++;
        }

        // Copy remaining elements
        while (i < n1) {
            bookprices[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            bookprices[k] = right[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int[] bookprices, int start, int end) {
        if (start < end) {
            int mid = start + (end - start) / 2;

            mergeSort(bookprices, start, mid);
            mergeSort(bookprices, mid + 1, end);

            merge(bookprices, start, mid, end);
        }
    }

    public static void printBookPrices(int[] bookprices) {
        System.out.println(Arrays.toString(bookprices));
    }

    public static void main(String[] args) {
        int[] bookprices = {102, 110, 104, 101, 108, 105};
        System.out.print("Original BookPrices : ");
        printBookPrices(bookprices);
         
        mergeSort(bookprices, 0, bookprices.length - 1);
        System.out.print("Sorted BookPrices in ascending order : ");
        printBookPrices(bookprices);
    }
}
