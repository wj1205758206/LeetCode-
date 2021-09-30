package codingoffer;

import java.util.Arrays;

/**
 * n个骰子的点数(动态规划，正向递推)
 */
public class DicesProbability_60 {
    public static void main(String[] args) {
        Solution solution = new DicesProbability_60().new Solution();
        double[] doubles = solution.dicesProbability(2);
        for (double aDouble : doubles) {
            System.out.println(aDouble);
        }
    }

    class Solution {

        /**
         * 动态规划，正向递推
         *
         * @param n
         * @return
         */
        public double[] dicesProbability(int n) {
            //dp定义：设输入 n 个骰子的解（即概率列表）为 f(n) ，其中「点数和」 x 的概率为 f(n,x) 。
            /*
             *  dp[i][j] 代表前 i 个骰子的点数和 j 的概率，并执行状态转移。
             *  而由于  dp[i] 仅由 dp[i−1] 递推得出，为降低空间复杂度，只建立两个一维数组 dp , tmp 交替前进即可。
             * */
            double[] dp = new double[6];

            //只有一个骰子的时候，概率列表全部为1/6
            Arrays.fill(dp, 1 / 6.0);

            //从第二个骰子开始计算，分别计算出2-n个骰子所能构成的点数和以及对应的概率列表
            for (int i = 2; i <= n; i++) {
                //i个骰子可以构成 6*i-i+1 种点数和
                double[] temp = new double[6 * i - i + 1];
                //正向递推，由 i 个骰子的概率列表 递推出 i+1 个骰子的概率列表
                for (int j = 0; j < dp.length; j++) {
                    //前一个概率列表中的每一个概率，都会对新形成的点数和都会产生影响，所以要累加上一个概率/6，除以6是因为新加一个骰子，样本空间变大了
                    for (int k = 0; k < 6; k++) {
                        temp[j + k] += dp[j] / 6.0;
                    }
                }
                dp = temp;
            }
            return dp;
        }
    }
}
