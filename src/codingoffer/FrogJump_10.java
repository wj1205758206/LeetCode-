package codingoffer;

/**
 * 青蛙跳(斐波那契数列的变种)
 */
public class FrogJump_10 {
    public static void main(String[] args) {

    }

    class Solution {
        public int numWays(int n) {
            if (n == 0 || n == 1) return 1;
            int[] dp = new int[n + 1];
            dp[1] = 1;//只有一级台阶时，只有1种跳法
            dp[2] = 2;//两级台阶时，有两种跳法：第一次跳一步，第二次跳一步；直接跳两步

            for (int i = 3; i <= n; i++) {
                /*大于两级台阶时
                 * 如果选择第一次跳一步，那么就有f(n-1)种跳法
                 * 如果选择第一次跳两步，那么就有f(n-2)种跳法
                 * 很显然，就是斐波那契数列*/
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
            }

            return dp[n];
        }
    }
}
