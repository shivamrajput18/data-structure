package LinearandBinarySearch.BinarySearch;

public class FirstNegative {

    // method to return first negative number
    public static int findFirstNegative(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] < 0)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, -2, 2, 5, -6, 22 };

        System.out.println("First negative number index: " + findFirstNegative(arr));
        
    }
}
