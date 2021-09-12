package codingoffer;

import java.util.Arrays;

/**
 * 斐波那契数列(递归/备忘录/迭代)
 */
public class Fibonacci_10 {
    public static void main(String[] args) {
        Solution solution = new Fibonacci_10().new Solution();
        System.out.println(solution.fib3(51));
    }

    class Solution {
        /**
         * 暴力递归
         *
         * @param n
         * @return
         */
        public int fib(int n) {
            if (n <= 1)
                return n;

            return fib(n - 1) + fib(n - 2);
        }

        int[] memory;

        /**
         * 备忘录，自顶向下递归
         *
         * @param n
         * @return
         */
        public int fib2(int n) {
            memory = new int[n + 1];
            Arrays.fill(memory, -1);
            return helper(n);
        }

        private int helper(int n) {
            if (n == 0 || n == 1) return n;
            if (memory[n] != -1)
                return memory[n];

            memory[n] = (helper(n - 1) + helper(n - 2)) % 1000000007;

            return memory[n];
        }

        /**
         * 动态规划，使用dp表自底向上迭代计算
         *
         * @param n
         * @return
         */
        public int fib3(int n) {
            if (n == 0 || n == 1) return n;

            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;

            for (int i = 2; i <= n; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
            }

            return dp[n];
        }


    }
}
