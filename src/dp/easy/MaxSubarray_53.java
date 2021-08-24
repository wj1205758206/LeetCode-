package dp.easy;

/**
 * 最大子序和
 */
public class MaxSubarray_53 {
    public static void main(String[] args) {
        Solution solution = new MaxSubarray_53().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    class Solution {
        /**
         * 动态规划
         * <p>
         * 求最大值，是求最值问题，并且任何长度的子序列的和存在无关性，所以使用DP
         * 选择：数组中的每一个元素
         * 状态：选择数组中的一个元素进行累加，变化的状态是sum
         * 要求长度为i的数组中最长子序列和，可以先求出 i-1 长度的数组中最大子序列和，然后再根据加上第i个值，累加和是变大了还是变小了
         * 来决定是取 (n-i 长度的最大子序列和) 还是取 ( n-i 长度的最大子序列和 + 第i个值 )
         *
         * @param nums
         * @return
         */
        public int maxSubArray(int[] nums) {

            //基准条件，前n-1长度最大子序和初始值相当于0
            int pre = 0;
            //初始值相当于第一个元素就是最大子序和
            int max = nums[0];

            //遍历所有选择，状态根据不同选择作出变化
            //这里的状态是 i-1长度数组的最大子序和 以及 i长度数组的最大子序和
            for (int num : nums) {
                //从基准条件出发，根据加上当前num之后，pre是变大还是变小，来更新pre最大值
                pre = Math.max(pre + num, num);

                //更新了pre的值，max要么不变，那么取pre更新后的值
                max = Math.max(pre, max);
            }

            return max;
        }
    }
}
