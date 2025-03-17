//package Stack_Queue;

import java.util.Stack;

public class SortStack {

    public static void sortStack(Stack<Integer> stack){
        if(stack.isEmpty()) return;
        int temp = stack.pop();
        sortStack(stack);
        rec(stack, temp);
    }

    public static void rec(Stack<Integer> stack, int value){
        if(stack.isEmpty() || stack.peek() <= value){
            stack.push(value);
            return;
        }

        int temp = stack.pop();
        rec(stack,value);
        
        stack.push(temp);

    }



    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();

        st.push(1);
        st.push(30);
        st.push(-5);
        st.push(18);
        st.push(14);

        System.out.println(st);
        
        sortStack(st);
        System.out.println(st);
        
    }
}