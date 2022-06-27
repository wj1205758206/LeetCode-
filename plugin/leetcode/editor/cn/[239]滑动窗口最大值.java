
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue window = new MyQueue();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                //先填满窗口的前 k - 1
                window.push(nums[i]);
            } else {
                // 窗口向前滑动，加入新数字
                window.push(nums[i]);
                // 记录当前窗口的最大值
                result.add(window.max());
                // 移出旧数字
                window.pop(nums[i - k + 1]);
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
}

/**
 * 自定义的单调队列   队尾-->队头  递增
 */
class MyQueue {
    private LinkedList<Integer> maxQ = new LinkedList<>();

    public void push(int n) {
        //每次从队尾添加元素时，先把队列中小于当前值的元素都删除
        while (!maxQ.isEmpty() && maxQ.getLast() < n) {
            maxQ.pollLast();
        }
        // 然后将 n 加入尾部
        maxQ.addLast(n);
    }

    public void pop(int n) {
        //有可能添加新元素时把队列头的元素也给删除了，所以先判断一下
        if (maxQ.getFirst() == n) {
            maxQ.pollFirst();
        }
    }

    public int max() {
        //队列头始终保持最大值
        return maxQ.getFirst();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
