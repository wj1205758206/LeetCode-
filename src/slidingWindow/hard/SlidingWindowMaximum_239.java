package slidingWindow.hard;


import java.util.LinkedList;


/**
 * 滑动窗口问题，求窗口内最大值
 */
public class SlidingWindowMaximum_239 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        Solution solution = new Solution();
        int[] result = solution.maxSlidingWindow2(nums, 3);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    static class Solution {
        /**
         * 方法一：双指针方法暴力求解
         * 左指针指向窗口左端，右指针指向窗口右端，每次滑动时都调用求最大值函数
         * 这种方法可以求解大部分测试用例，但是一旦数据量爆炸，LeetCode会超时 时间复杂度为 O(nk)
         *
         * @param nums 传入的数组
         * @param k    滑动窗口长度
         * @return 返回滑动窗口滑动时，窗口内的最大值构成的数组
         */
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 0)
                return null;

            /*最大值构成的数组长度为nums.length - k + 1*/
            int[] max = new int[nums.length - k + 1];

            /*left指向窗口左端，right指向窗口右端*/
            int left = 0;
            int right = k - 1;
            int index = 0;

            /*left和right相同速度向右滑动，每次滑动调用求最大值函数*/
            while (right < nums.length) {
                max[index] = windowMax(nums, left, right);
                left++;
                right++;
                index++;
            }

            return max;
        }

        public int windowMax(int[] nums, int left, int right) {
            int max = left;
            for (int i = left; i <= right; i++) {
                if (nums[max] < nums[i])
                    max = i;
            }
            return nums[max];
        }


        /**
         * 方法二：实现单调队列结构，通过单调队列来操作滑动窗口的移动以及取出最大值
         * @param nums  传入的查找数组
         * @param k 滑动窗口的长度
         * @return  返回滑动窗口滑动时，窗口内的最大值构成的数组
         */
        public int[] maxSlidingWindow2(int[] nums, int k) {
            MonotonicQueue window = new MonotonicQueue();
            int[] max = new int[nums.length - k + 1];

            for (int i = 0; i < nums.length; i++) {
                /*先填满窗口的前k-1个数，只有满了k个数才会选出最大值*/
                if (i < k -1) {
                    window.push(nums[i]);
                }else {
                    /*窗口向前滑动，加入新元素*/
                    window.push(nums[i]);
                    /*因为钱k-1个数不会选取最大值，索引max数组的索引从i-k+1开始。即从0开始*/
                    max[i - k + 1] = window.max();
                    /*i-k+1表达的是窗口左端在数组中的索引，即每次滑动需要弹出队列头部元素*/
                    window.pop(nums[i - k + 1]);
                }
            }

            return max;
        }
    }

    /**
     * 实现单调队列数据结构
     */
    static class MonotonicQueue {
        /*使用LinkedList链表结构，方便从头部和尾部快速的插入删除元素*/
        LinkedList<Integer> q = new LinkedList<>();

        /*每次push元素时，即窗口右端前进一步时，把新元素push进来之前，先把队列中比新元素小的都弹出来，然后再把新元素放到队列尾部
        * 这样做能保证队列头部始终保存的是窗口范围内的最大值
        * 队列呈现一个单调递减的形势*/
        public void push(int n) {
            while (!q.isEmpty() && q.getLast() < n) {
                q.pollLast();
            }
            q.addLast(n);
        }

        /*队列单调递减，队列头部则保存着当前滑动窗口的最大值*/
        public int max() {
            return q.getFirst();
        }

        /*窗口向右滑动时，左端也是前进的，所以要弹出头部元素
        * 需要判断当前队列的头部是否是原数组nums中的数，因为有可能当新元素push进来的时候，会把比它小的数清空，有可能头部也比它小
        * 此时尾部元素也是头部元素，这种清空不应该清空头部元素*/
        public void pop(int n) {
            if (n == q.getFirst())
                q.pollFirst();
        }
    }
}
