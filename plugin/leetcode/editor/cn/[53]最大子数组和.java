
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
