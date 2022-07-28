
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1; //组成0金额的 只有一种方法，就是不选择
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0; //没有选择想组成金额j的方法，有0种
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (j - coins[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j]; //继承上一次结果
                } else {
                    //可以选，也可以不选，计算这两种选择的之和，可得出一共有几种
                    dp[i][j] = dp[i - 1][j] //不选
                            + dp[i][j - coins[i - 1]]; //选
                }
            }
        }
        return dp[n][amount]; //想要返回n个硬币组成amount金额的方法有dp[n][amount]种
    }
}
//leetcode submit region end(Prohibit modification and deletion)
