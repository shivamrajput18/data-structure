import java.util.Arrays;

public class ProductPrices {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static int partition(int[] productprices, int start, int end) {
       int pivot = productprices[start];
       int i = start + 1;
       int j = end;

       while (i <= j) {
         while (i <= end && productprices[i] <= pivot) {
            i++;
         }

        while (j >= start && productprices[j] > pivot) {
            j--;
        }

        if (i < j) {
            swap(productprices, i, j);
        }         
     }

       swap(productprices, start, j);
       return j;
    }

    public static void quickSort(int[] productprices, int start, int end) {
        if (start < end) {
            int pivotIndx = partition(productprices, start, end);

            quickSort(productprices, start, pivotIndx - 1);
            quickSort(productprices, pivotIndx + 1, end);
        }
    }

    public static void printProductPrices(int[] bookprices) {
        System.out.println(Arrays.toString(bookprices));
    }

    public static void main(String[] args) {
        int[] productprices = {102, 110, 104, 101, 108, 105};
        System.out.print("Original ProductPrices: ");
        printProductPrices(productprices);
         
        quickSort(productprices, 0, productprices.length - 1);
        System.out.print("Sorted ProductPrices in ascending order: ");
        printProductPrices(productprices);
    }
}
