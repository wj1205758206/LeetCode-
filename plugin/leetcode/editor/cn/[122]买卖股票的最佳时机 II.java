
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
//        int maxK = 0;
//        int[][][] dp = new int[n][maxK + 1][2];
        int[][] dp = new int[n][2];

        for (int i = 0; i < n; i++) {

            if (i - 1 == -1) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);

        }
        return dp[n - 1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
