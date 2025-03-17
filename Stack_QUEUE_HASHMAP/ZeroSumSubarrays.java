//package HashMap;

import java.util.*;

public class ZeroSumSubarrays {
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        int cumulativeSum = 0;

        // Initialize HashMap to handle subarrays starting from index 0
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);

        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];

            // If the cumulative sum has been seen before, subarrays exist
            if (sumMap.containsKey(cumulativeSum)) {
                for (int startIndex : sumMap.get(cumulativeSum)) {
                    result.add(new int[]{startIndex + 1, i});  // Subarray from startIndex+1 to i
                }
            }

            // Add current index to the list of indices for this cumulative sum
            sumMap.putIfAbsent(cumulativeSum, new ArrayList<>());
            sumMap.get(cumulativeSum).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, -3, -1, 0, 4};
        List<int[]> subarrays = findZeroSumSubarrays(arr);

        System.out.println("Subarrays with zero sum:");
        for (int[] subarray : subarrays) {
            System.out.println(Arrays.toString(subarray));
        }
    }
}