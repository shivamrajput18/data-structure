//package Stack_Queue;

import java.util.Stack;

public class SortStackRecursively {
    public static void sortStack(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();
            sortStack(stack);
            insertSorted(stack, temp);
        }
    }

    private static void insertSorted(Stack<Integer> stack, int item) {
        if (stack.isEmpty() || stack.peek() <= item) {
            stack.push(item);
        } else {
            int temp = stack.pop();
            insertSorted(stack, item);
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);

        sortStack(stack);
        System.out.println(stack); // Output: [1, 2, 3, 4]
    }
}