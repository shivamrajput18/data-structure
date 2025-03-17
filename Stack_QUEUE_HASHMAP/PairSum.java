//package HashMap;

import java.util.*;

class PairSum {
    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(target - num)) {
                return true; // Pair found
            }
            set.add(num);
        }
        return false; // No pair found
    }

    public static void main(String[] args) {
        int[] arr = {10, 15, 3, 7};
        int target = 17;
        System.out.println(hasPairWithSum(arr, target)); // Output: true (10 + 7)
    }
}