package com.soulmeadows;

import java.util.ArrayDeque;
import java.util.Deque;

public class CustomStack {
        private Deque<Integer> queue;

        public CustomStack() {
            queue = new ArrayDeque<Integer>();
        }

        public void push(int x) {
            queue.push(x);
        }

        public int pop() {
            return queue.pop();
        }

        public int peek() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }


    public static void main(String[] args) {

        //Your MyQueue object will be instantiated and called as such:
        CustomStack obj = new CustomStack();
        obj.push(1);
        obj.push(2);

        int param_3 = obj.peek();
        int param_2 = obj.pop();

        boolean param_4 = obj.empty();
    }
}

