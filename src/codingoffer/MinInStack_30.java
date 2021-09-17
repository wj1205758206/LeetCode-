package codingoffer;

import java.util.Stack;

/**
 * 包含min函数的栈
 */
public class MinInStack_30 {
    public static void main(String[] args) {

    }

    class MinStack {

        /**
         * 维护两个栈，stack存放元素 minStack存放每次压栈时最小元素
         */
        Stack<Integer> stack = null;
        Stack<Integer> minStack = null;

        public MinStack() {
            stack = new Stack<>();
            minStack = new Stack<>();
        }

        public void push(int x) {
            if (stack.isEmpty()) {
                stack.push(x);
                minStack.push(x);
            } else {
                stack.push(x);
                if (minStack.peek() <= x) {
                    minStack.push(minStack.peek());
                } else {
                    minStack.push(x);
                }
            }
        }

        public void pop() {
            stack.pop();
            minStack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }
}
