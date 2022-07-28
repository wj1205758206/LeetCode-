
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        // 定义：dp[i] 记录以 nums[i] 为结尾的「最大子数组和」
        int[] dp = new int[n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            // 要么自成一派，要么和前面的子数组合并
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
