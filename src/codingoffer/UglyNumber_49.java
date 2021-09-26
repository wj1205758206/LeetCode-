package codingoffer;

/**
 * 计算第n个丑数
 */
public class UglyNumber_49 {
    public static void main(String[] args) {
        Solution solution = new UglyNumber_49().new Solution();
        System.out.println(solution.nthUglyNumber2(1500));
    }

    class Solution {
        /**
         * 暴力求解，超时
         *
         * @param n
         * @return
         */
        public int nthUglyNumber(int n) {
            if (n == 1) return 1;
            int res = -1;
            for (int i = 2; i < Integer.MAX_VALUE; i++) {
                if (isUgly(i)) {
                    n--;
                    res = i;
                }
                if (n == 1) break;
            }
            return res;
        }

        private boolean isUgly(int number) {
            while (number % 2 == 0) number /= 2;
            while (number % 3 == 0) number /= 3;
            while (number % 5 == 0) number /= 5;

            return number == 1 ? true : false;
        }

        /**
         * 动态规划，通过上一个丑数，计算出下一个丑数
         * 丑数：只能被2、3、5整除的数
         *
         * @param n
         * @return
         */
        public int nthUglyNumber2(int n) {
            int a = 0, b = 0, c = 0;

            //dp定义：第n和丑数为dp[n-1]
            int[] dp = new int[n];
            //规定第一个丑数是1
            dp[0] = 1;

            for (int i = 1; i < n; i++) {
                //下一个丑数只能是前面已经计算出来的丑数乘以2、3、5，取最小值作为下一个丑数
                int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
                dp[i] = Math.min(n2, Math.min(n3, n5));
                //要保证计算出来的下一个丑数要大于已知的最大丑数
                if (dp[i] == n2) a++;
                if (dp[i] == n3) b++;
                if (dp[i] == n5) c++;
            }
            return dp[n - 1];
        }
    }
}
