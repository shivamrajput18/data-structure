//package Stack_Queue;

import java.util.Stack;

class Queue {

    private Stack<Integer> st1 = new Stack<>();
    private Stack<Integer> st2 = new Stack<>();

    // enqueue
    public void enqueue(int n) {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }

        st1.push(n);

        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }
    }

    public int dequeue() {

        if (st1.empty()) {
            return -1;
        }

        int n = st1.peek();
        st1.pop();
        return n;
    }

}

public class QueueUsingTwoStack {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
    }
}