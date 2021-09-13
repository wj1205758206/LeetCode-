package codingoffer;

/**
 * 剪绳子
 */
public class CuttingRope_14 {
    public static void main(String[] args) {
        Solution solution = new CuttingRope_14().new Solution();
        System.out.println(solution.cuttingRope(8));
    }

    class Solution {

        public int cuttingRope(int n) {
            //保存2-n长度的对应的剪成若干段的长度乘积最大值
            int[] dp = new int[n + 1];

            //基准条件
            dp[2] = 1;

            /*从长度为3开始计算*/
            for (int i = 3; i <= n; i++) {
                /*做出选择，从长度为1开始剪，然后剪出长度为2的，为3的。。。
                 * 1*2=2*1，所以j<= i/2只算一半即可*/
                for (int j = 1; j <= i / 2; j++) {
                    //剪出来剩下的i-j长度的绳子，可以选择继续剪，也可以选择不剪，取二者最大值
                    dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
                }
            }
            return dp[n];
        }
    }
}
