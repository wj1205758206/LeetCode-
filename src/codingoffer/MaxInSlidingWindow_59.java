package codingoffer;

import java.util.LinkedList;

/**
 * 求滑动窗口中最大值
 */
public class MaxInSlidingWindow_59 {
    public static void main(String[] args) {
        Solution solution = new MaxInSlidingWindow_59().new Solution();
        int[] res = solution.maxSlidingWindow2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        for (int num : res) {
            System.out.println(num);
        }
    }

    class Solution {
        /**
         * 暴力解法
         *
         * @param nums
         * @param k
         * @return
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0 || k <= 0) return new int[0];
            int n = nums.length;
            int[] res = new int[n - k + 1];
            int index = 0;
            int left = 0;
            int right = left + k - 1;
            int curMax = Integer.MIN_VALUE;
            int curMaxIndex = -1;

            while (right < n) {
                if (left > curMaxIndex) {
                    curMaxIndex = getMax(nums, left, right);
                    curMax = nums[curMaxIndex];
                    res[index++] = curMax;
                } else {
                    if (nums[right] <= curMax) {
                        res[index++] = curMax;
                    } else {
                        curMax = nums[right];
                        curMaxIndex = right;
                        res[index++] = curMax;
                    }
                }
                left++;
                right++;
            }
            return res;
        }

        private int getMax(int[] nums, int left, int right) {
            int max = left;
            for (int i = left; i <= right; i++) {
                if (nums[max] < nums[i])
                    max = i;
            }
            return max;
        }

        /**
         * 维护一个单调队列
         *
         * @param nums
         * @param k
         * @return
         */
        public int[] maxSlidingWindow2(int[] nums, int k) {
            MonotonicQueue window = new MonotonicQueue();
            int[] max = new int[nums.length - k + 1];
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (i < k - 1) {
                    window.push(nums[i]);
                } else {
                    window.push(nums[i]);
                    max[index++] = window.max();
                    window.pop(i - k + 1);
                }
            }
            return max;
        }
    }

    class MonotonicQueue {
        LinkedList<Integer> queue = new LinkedList<>();

        public void push(int n) {
            while (!queue.isEmpty() && queue.getLast() < n) queue.pollLast();
            queue.addLast(n);
        }

        public int max() {
            return queue.getFirst();
        }

        public void pop(int n) {
            if (n == queue.getFirst())
                queue.pollFirst();
        }
    }

}
