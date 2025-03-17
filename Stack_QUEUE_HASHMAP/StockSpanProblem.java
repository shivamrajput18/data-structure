//package Stack_Queue;

import java.util.Stack;

public class StockSpanProblem {
    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && prices[st.peek()] <= prices[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - st.peek();
            }

            st.push(i);

        }
        return span;
    }

    public static void main(String[] args) {
        int[] prices = { 100, 80, 60, 70, 60, 75, 85 };
        int[] spans = calculateSpan(prices);

        // Print the spans
        System.out.println("Stock Prices:");
        for (int price : prices) {
            System.out.print(price + " ");
        }
        System.out.println("\nStock Spans:");
        for (int span : spans) {
            System.out.print(span + " ");
        }
    }
}