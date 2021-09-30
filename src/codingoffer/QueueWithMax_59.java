package codingoffer;

import java.util.LinkedList;

/**
 * 队列的最大值
 */
public class QueueWithMax_59 {
    public static void main(String[] args) {

    }

    class MaxQueue {
        LinkedList<Integer> queue = null;
        LinkedList<Integer> helper = null;

        public MaxQueue() {
            this.queue = new LinkedList();
            this.helper = new LinkedList<>();
        }

        public int max_value() {
            return helper.isEmpty() ? -1 : helper.pollFirst();
        }

        public void push_back(int value) {
            queue.add(value);
            while (!helper.isEmpty() && helper.getLast() < value)
                helper.pollLast();
            helper.addLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty())
                return -1;
            //如果弹出的刚好使队列中的最大值，那么单调队列需要把这个首部的最大值也弹出来，首部成为了次最大值
            if (queue.peek().equals(helper.peekFirst()))
                helper.pollFirst();
            return queue.pollFirst();
        }
    }
}
