package dp.medium;

import java.util.Arrays;

/**
 * 两个字符串的删除操作
 */
public class DeleteOperationForTwoStrings_583 {
    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";

        Solution solution = new DeleteOperationForTwoStrings_583().new Solution();
        System.out.println(solution.minDistance(word1, word2));
    }

    class Solution {
        /**
         * 方法一：动态规划，使用dp数组，自底向上计算
         *
         * @param word1
         * @param word2
         * @return
         */
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();

            /*首先明确dp数组的定义
             * dp[i][j]保存着 word1[0..i-1] he  word2[0..j-1] 两个字符串找到使得 word1 和 word2 相同所需的最小步数*/
            int[][] dp = new int[m + 1][n + 1];

            for (int i = 0; i < dp.length; i++) {
                //初始化为m+n,即全部删除
                Arrays.fill(dp[i], 0);
            }


            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = i + j;
                    }
                }
            }

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        /*如果上一轮比较，两个元素相等
                         * 那么当前dp数组应该保存上轮的最大步数-2，因为两个元素相等，那么就可以少执行两次删除操作*/
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        /*如果当前两个值不相等，*/
                        /*dp[i][j] = retMin(
                                dp[i - 1][j] + 1,
                                dp[i][j - 1] + 1,
                                dp[i - 1][j - 1] + 1
                        );*/
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    }
                }
            }
            return dp[m][n];
        }

        private int retMin(int i, int j, int k) {
            return Math.min(Math.min(i, j), k);
        }

        /**
         * 方法二：这其实就是最长公共子序列的变种
         *
         * @param word1
         * @param word2
         * @return
         */
        public int minDistance2(String word1, String word2) {
            /*题目让我们计算将两个字符串变得相同的最少删除次数，那我们可以思考一下，最后这两个字符串会被删成什么样子？
             *删除的最终结果不就是它俩的最长公共子序列嘛！*/

            LongestCommonSubsequence_1143.Solution solution = new LongestCommonSubsequence_1143().new Solution();
            int lcs = solution.longestCommonSubsequence2(word1, word2);

            return word1.length() - lcs + word2.length() - lcs;
        }
    }
}
