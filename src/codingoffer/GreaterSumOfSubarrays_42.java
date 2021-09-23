package codingoffer;

/**
 * 连续子数组的最大和
 */
public class GreaterSumOfSubarrays_42 {
    public static void main(String[] args) {
        Solution solution = new GreaterSumOfSubarrays_42().new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

    class Solution {
        /**
         * 利用数组规律特征求解
         *
         * @param nums
         * @return
         */
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            if (n == 0) return 0;

            int curSum = 0;
            int maxSum = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {

                //如果加上当前元素，当前和反而变小了，说明之前的和是负数，起到了副作用，所以更新curSum为当前元素
                if (curSum + nums[i] <= nums[i])
                    curSum = nums[i];
                else
                    curSum += nums[i]; //如果curSum不是负数，则进行累加

                //curSum有可能累加了一个负数会变小，那么maxSum应为之前的curSUm
                //如果curSum累加了一个正数，curSum会变大，那么就更新maxSum
                if (curSum > maxSum)
                    maxSum = curSum;

            }
            return maxSum;
        }

        /**
         * 动态规划，使用dp列表自底向上迭代计算
         *
         * @param nums
         * @return
         */
        public int maxSubArray2(int[] nums) {
            if (nums.length == 0) return 0;

            //dp定义为 ： 以下标i结尾的数组连续子数组的最大和为dp[i]
            int[] dp = new int[nums.length];
            dp[0] = nums[0];//初始值，也就是第一个元素

            int res = dp[0];

            for (int i = 1; i < nums.length; i++) {
                //通过dp[i-1]来推导出dp[i]
                //如果前一个小于等于0，说明之前的最大和为负数或0，那么下一个最大和应为当前遍历的数组元素
                //如果前一个最大和大于0，那么下一个最大和就需要累加当前元素
                dp[i] = dp[i - 1] <= 0 ? nums[i] : dp[i - 1] + nums[i];

                //取所有最大和的最大的那个值
                res = Math.max(res, dp[i]);
            }
            return res;
        }
    }
}