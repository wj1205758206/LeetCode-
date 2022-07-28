
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false; //如果sum不能整除2，那么就无法划分两个相等子集
        sum /= 2;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true; //背包容量0，说明可以放满
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = false; //没有物品可以选择，说明放不满
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j]; //背包容量不足，继承上一个结果
                } else {
                    //背包容量足，但是可选择放还是不放,只要有一个选择能为true，择说明能装满
                    dp[i][j] = dp[i - 1][j] //选择不放入
                            || dp[i - 1][j - nums[i - 1]]; //选择放入
                }
            }
        }
        return dp[nums.length][sum];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
