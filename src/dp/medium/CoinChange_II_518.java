package dp.medium;

/**
 * 零钱兑换2(完全背包问题)
 */
public class CoinChange_II_518 {
    public static void main(String[] args) {
        int amount = 500;
        int[] coins = {2, 3, 5, 7, 8, 9, 10, 11};

        Solution solution = new CoinChange_II_518().new Solution();
        System.out.println(solution.change(amount, coins));
    }

    class Solution {
        /**
         * 可以转为完全背包问题
         * 第一步：确定状态和选择
         *        状态：背包的容量、可选择的物品
         *        选择：当前物品你选择放 还是不放入
         *
         * 第二步：明确dp数组的定义
         *        状态有两个，需要一个二维数组，每个状态作为他的一个维度
         *        定义：若只使用前 i 个物品（可以重复使用），当背包容量为 j 时，有 dp[i][j] 种方法可以装满背包
         *        此定义满足重复使用的条件
         *
         * 第三步：根据选择，确定状态转移的逻辑
         *        如果你不把这第 i 个物品装入背包，也就是说你不使用 coins[i] 这个面值的硬币，那么凑出面额 j 的方法数 dp[i][j] 应该等于 dp[i-1][j]，继承之前的结果。
         *        如果你把这第 i 个物品装入了背包，也就是说你使用 coins[i] 这个面值的硬币，那么 dp[i][j] 应该等于 dp[i][j-coins[i-1]]。
         *        而我们想求的 dp[i][j] 是「共有多少种凑法」，所以 dp[i][j] 的值应该是以上两种选择的结果之和
         * @param amount
         * @param coins
         * @return
         */
        public int change(int amount, int[] coins) {
            int n = coins.length;

            int[][] dp = new int[n + 1][amount + 1];

            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = 1;
            }
            for (int j = 0; j < dp[0].length; j++) {
                dp[0][j] = 0;
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= amount; j++) {
                    if (j - coins[i - 1] >= 0) {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - coins[i - 1]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }

                }
            }
            return dp[n][amount];
        }
    }
}
