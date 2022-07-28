
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int n = nums.length;
        return Math.max(robRange(nums, 0, n - 2), robRange(nums, 1, n - 1));
    }

    public int robRange(int[] nums, int start, int end) {
        int n = end + 1;
        int[] dp = new int[n + 2];
        for (int i = end; i >= start; i--) {
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }
        return dp[start];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
