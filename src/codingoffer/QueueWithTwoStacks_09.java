package codingoffer;

import java.util.Stack;

/**
 * 两个栈实现队列
 */
public class QueueWithTwoStacks_09 {
    public static void main(String[] args) {

    }

    class CQueue {
        private Stack<Integer> s1;
        private Stack<Integer> s2;

        public CQueue() {
            this.s1 = new Stack<>();
            this.s2 = new Stack<>();
        }

        public void appendTail(int value) {
            s1.push(value);
        }

        public int deleteHead() {
            if (s2.isEmpty()) {
                if (s1.isEmpty()) {
                    return -1;
                } else {
                    while (!s1.isEmpty()) {
                        Integer val = s1.pop();
                        s2.push(val);
                    }
                    Integer res = s2.pop();
                    return res;
                }
            } else {
                return s2.pop();
            }
        }
    }
}
