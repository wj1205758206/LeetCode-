
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        //dp[]定义：当目标金额为 i 时，至少需要 dp[i] 枚硬币凑出
        int[] dp = new int[amount + 1];
        Arrays.fill(coins, amount + 1);

        //base case: 金额为0，不需要凑
        dp[0] = 0;
        //状态：amount，遍历所有状态的所有取值
        for (int i = 0; i < dp.length; i++) {
            //选择: 不同coin,
            for (int coin : coins) {
                if (i - coin < 0) continue;
                //不同选择会导致amount的变化,选取最优子结构
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
113