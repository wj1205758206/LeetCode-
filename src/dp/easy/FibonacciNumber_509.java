package dp.easy;

/**
 * 动态规划斐波那契数列
 */
public class FibonacciNumber_509 {
    public static void main(String[] args) {
        Solution solution = new FibonacciNumber_509().new Solution();
        System.out.println(solution.fib3(4));
    }

    class Solution {
        /**
         * 方法一：递归
         *
         * @param n
         * @return
         */
        public int fib(int n) {

            if (n == 0 || n == 1)
                return n;
            return fib(n - 1) + fib(n - 2);
        }

        /**
         * 方法二：使用备忘录进行递归，消除重复计算，自顶向下的计算
         *
         * @param n
         * @return
         */
        public int fib2(int n) {
            int[] memory = new int[n + 1];
            return helper(memory, n);
        }

        private int helper(int[] memory, int n) {

            if (n == 0 || n == 1)
                return n;

            /*在递归过程中，先判断子问题是否已经计算过并保存结果了
             * 查找备忘录如果已经计算过当前子问题，则直接返回备忘录中记录的结果即可*/
            if (memory[n] != 0)
                return memory[n];

            /*如果还没有计算过这个子问题，就正常进行递归计算，并保存这个结果，待后续使用*/
            memory[n] = helper(memory, n - 1) + helper(memory, n - 2);

            /*返回备忘录中计算的结果*/
            return memory[n];
        }

        /**
         * 方法三：动态规划，使用dp表，自底向上迭代计算
         *
         * @param n
         * @return
         */
        public int fib3(int n) {
            if (n == 0 || n == 1)
                return n;

            int[] dp = new int[n + 1];

            //基准条件
            dp[0] = 0;
            dp[1] = 1;

            //根据状态转移，计算dp表中每一个结果
            for (int i = 2; i < dp.length; i++) {
                //由前两个元素可动态的规划处下一个元素
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            //迭代完，dp表中穷举了所有可能
            return dp[n];
        }
    }
}
