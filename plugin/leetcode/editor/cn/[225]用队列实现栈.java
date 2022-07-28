
//leetcode submit region begin(Prohibit modification and deletion)
class MyStack {
    int top = 0;
    Queue<Integer> queue = null;

    public MyStack() {
        this.top = 0;
        this.queue = new LinkedList<>();
    }

    public void push(int x) {
        //队尾就是栈顶
        queue.offer(x);
        top = x;
    }

    public int pop() {
        int size = queue.size();
        while (size > 2) {
            queue.offer(queue.poll());
            size--;
        }
        top = queue.peek(); //剩余的两个 中的第一个将为弹出了，重新入队，成为栈顶
        queue.offer(queue.poll());
        return queue.poll();
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return queue.isEmpty();
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
//leetcode submit region end(Prohibit modification and deletion)
