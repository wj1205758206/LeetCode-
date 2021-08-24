package dp.medium;

import java.util.Arrays;

/**
 * 零钱兑换
 */
public class CoinChange_322 {
    public static void main(String[] args) {
        int[] conis = {1, 2, 5};
        int amount = 11;

        Solution solution = new CoinChange_322().new Solution();
        System.out.println(solution.coinChange(new int[]{2}, 3));
    }

    class Solution {

        /**
         * 方法一：暴力递归求解
         *
         * @param coins  硬币面额数组，动态规划中的选择，也就是导致状态产生变化的行为
         * @param amount 目标金额，动态规划中的状态，也就是原问题和子问题中会变化的变量，根据不同的选择产生不同的状态变化
         * @return
         */
        public int coinChange(int[] coins, int amount) {
            return dp(coins, amount);
        }

        private int dp(int[] coins, int amount) {

            /*基准条件*/
            if (amount == 0)
                return 0;
            if (amount < 0)
                return -1;

            int result = Integer.MAX_VALUE;

            /*确定选择
             * 这里不同的面额就是选择，不同选择会产生不同的状态变化，也就是产生目标金额的变化*/
            for (int i = 0; i < coins.length; i++) {

                /*确定状态
                 * 根据当前的选择amount产生了状态变化，分解成了不同的子问题*/
                int subProblem = dp(coins, amount - coins[i]);
                if (subProblem == -1)
                    continue;

                /*每次选择取子问题的最小值
                 *加1是因为子问题求出来的最少硬币数量，需要再加上一种面额的选择，才是原问题的最少硬币数量*/
                result = Math.min(result, subProblem + 1);
            }

            /*如果遍历完了所有不同的选择，结果是MAX_VALUE，说明子问题都无解
             * 否则返回计算的最后结果值*/
            return result == Integer.MAX_VALUE ? -1 : result;
        }

        /**
         * 方法二：带备忘录的递归求解
         *
         * @param coins
         * @param amount
         * @return
         */
        private int dp2(int[] coins, int amount) {
            int[] memory = new int[amount + 1];
            Arrays.fill(memory, -2);

            //加上备忘录减少了重复计算，相当于剪枝操作
            return dp2Helper(coins, amount, memory);
        }

        private int dp2Helper(int[] coins, int amount, int[] memory) {

            /*基准条件*/
            if (amount == 0)
                return 0;
            if (amount < 0)
                return -1;

            /*每次递归，首先判断备忘录中是否当前需要计算的值，之前已经计算出结果了
             * 如果之前计算过，则直接查表返回结果*/
            if (memory[amount] != -2)
                return memory[amount];

            int result = Integer.MAX_VALUE;

            for (int coin : coins) {

                //确定选择，进行状态变化，求解出子问题
                int subProblem = dp2Helper(coins, amount - coin, memory);

                //说明当前的选择产生的子问题无解，直接跳过，继续下一个选择
                if (subProblem == -1)
                    continue;

                //在子问题中选择最优解，然后加1还原原问题的解
                result = Math.min(result, subProblem + 1);
            }

            /*将计算出的结果加入到备忘录，以便下一次的使用*/
            memory[amount] = result == Integer.MAX_VALUE ? -1 : result;

            return memory[amount];
        }

        /**
         * 方法三：使用dp迭代计算，自底向上
         *
         * @param coins
         * @param amount
         * @return
         */
        private int dp3(int[] coins, int amount) {

            //将dp数组大小初始化为amount+1，是因为空着索引0的值为0
            int[] dp = new int[amount + 1];

            //将dp数组的值初始化为amount+1，
            // 是因为凑成 amount 金额的硬币数最多只可能等于 amount（全用 1 元面值的硬币），
            // 所以初始化为 amount + 1 就相当于初始化为正无穷，
            // 也可以是其它值，只要能区别开来即可
            Arrays.fill(dp, amount + 1);

            /*基准条件
             * 自底向上计算，底就是0*/
            dp[0] = 0;

            /*遍历所有的状态，也就是遍历计算出所有amount对应的最少硬币数量*/
            for (int i = 0; i < dp.length; i++) {

                /*根据当前遍历的amount作出不同的选择，求出所有选择的最小值*/
                for (int coin : coins) {

                    //如果说当前的amount小于了当前作出的选择，那么就无解，直接跳过当前选择，继续下一次的选择
                    if (i - coin < 0)
                        continue;

                    //求出子问题的最优值，dp[i]保存的是遍历完所有选择后的最小值
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }

            //如果计算完所有的状态，如果是初始值，说明当前状态作出的所有选择都无解，即原问题无解，返回-1
            //否则返回计算出的结果值
            return (dp[amount] == amount + 1) ? -1 : dp[amount];
        }
    }
}
