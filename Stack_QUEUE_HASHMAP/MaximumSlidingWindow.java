//package Stack_Queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaximumSlidingWindow {
    
    public static int[] maximum(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[n - k + 1];
        int idx = 0;
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // check for bound
            if (!dq.isEmpty() && dq.peek() == i - k) {
                dq.poll();
            }

            // remove all smaller element

            while (!dq.isEmpty() && arr[dq.peekLast()] < arr[i]) {
                dq.pollLast();
            }

            dq.offer(i);
            
            // adding the ans with k-1 index 
            if (i >= k - 1) {
                ans[idx++] = arr[dq.peek()];
            }

        }

        return ans;
    }

    public static void main(String[] args) {

        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };

        int[] result = maximum(arr, 3);

        System.out.println(Arrays.toString(result));

    }
}