
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        if (nums[0] == 0) return false;
        int n = nums.length;
//        int farthest = 0;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n - 1; i++) {
            // 不断计算能跳到的最远距离
//            farthest = Math.max(farthest, i + nums[i]);
            dp[i] = Math.max(dp[i - 1], i + nums[i]);
            // 可能碰到了 0，卡住跳不动了
            if (dp[i] <= i) {
                return false;
            }
        }
        return dp[n - 2] >= n - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
