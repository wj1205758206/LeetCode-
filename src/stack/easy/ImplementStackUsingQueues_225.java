package stack.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 使用队列实现栈
 */
public class ImplementStackUsingQueues_225 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        System.out.println(myStack.pop());

    }
    static class MyStack {
        /*底层还是一个队列操作*/
        public Queue<Integer> queue = null;
        int top = 0;

        /** Initialize your data structure here. */
        public MyStack() {
            queue = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            /*每次push新元素，放到队列尾部，top记录尾部元素*/
            queue.offer(x);
            top = x;
        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            /*循环把尾部前面的元素全部弹出，并且重新加入到队列尾部，这样原来尾部的元素成为了队列头部元素*/
            int size = queue.size();
            while (size > 1) {
                queue.offer(queue.poll());
                size--;
            }
            /*弹出队列头部元素，即为栈顶元素*/
            return queue.poll();
        }

        /** Get the top element. */
        public int top() {
            /*查看栈顶元素，即为队列的尾部元素*/
            return top;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            /*底层队列为空，即栈为空*/
            if (queue.isEmpty())
                return true;
            return false;
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
