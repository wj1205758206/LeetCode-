package codingoffer;

/**
 * 股票的最大利润(买卖一次)
 */
public class MaxProfit_63 {
    public static void main(String[] args) {
        Solution solution = new MaxProfit_63().new Solution();
        System.out.println(solution.maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
    }

    class Solution {
        /**
         * 暴力求解
         *
         * @param prices
         * @return
         */
        public int maxProfit(int[] prices) {
            int max = 0;
            for (int i = 0; i < prices.length; i++) {
                for (int j = i + 1; j < prices.length; j++) {
                    if (prices[j] > prices[i])
                        max = Math.max(max, prices[j] - prices[i]);
                }
            }
            return max;
        }

        /**
         * 动态规划
         *
         * @param prices
         * @return
         */
        public int maxProfit2(int[] prices) {
            if (prices.length == 0) return 0;
            //dp定义：前n天最大利润为dp[n-1]
            int[] dp = new int[prices.length];
            //初始第一天利润为0
            dp[0] = 0;
            //min用来记录前n-1天最小价格
            int min = prices[0];
            //迭代计算，前n天可以获得的最大利润
            for (int i = 1; i < dp.length; i++) {
                min = Math.min(min, prices[i]); //更新前n-1天最小价格
                //状态转移：
                // 求第n天最大利润时，可以获得前n-1天的最大利润，通过第n天的价格 - 前n-1天的最小价格，可以计算出第n天的利润
                // 二者取最大值
                dp[i] = Math.max(dp[i - 1], prices[i] - min);
            }
            return dp[prices.length - 1];
        }
    }
}
