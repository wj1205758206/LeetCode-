package stack.easy;

import java.util.Stack;

/**
 * 使用栈实现队列
 */
public class ImplementQueueUsingStacks_232 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.peek());
    }

    /**
     * 使用两个栈 s1 和 s2
     * push元素时压入 s1
     * 当 peek 获取队列头部元素时，如果 s2 还有元素，接直接获取，如果 s2 已经没有元素，就先把 s1 全部元素弹出并压入 s2，经过两次栈，负负得正
     * 当 pop 弹出队列头部元素时，如果 s2 还有元素，就直接弹出，如果 s2 已经没有元素，就先调用 peek 然后再弹出栈顶元素
     */
    static class MyQueue {
        public Stack<Integer> s1 = null;
        public Stack<Integer> s2 = null;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            s1.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (!s2.isEmpty())
                return s2.pop();
            peek();
            return s2.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            if (!s2.isEmpty())
                return s2.peek();
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            return s2.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            if (s1.isEmpty() && s2.isEmpty())
                return true;
            return false;
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
