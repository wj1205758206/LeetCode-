package dp.medium;

import java.util.Arrays;

/**
 * 最长公共子序列
 */
public class LongestCommonSubsequence_1143 {
    public static void main(String[] args) {
        String text1 = "abc";
        String text2 = "def";

        Solution solution = new LongestCommonSubsequence_1143().new Solution();
        System.out.println(solution.longestCommonSubsequence(text1, text2));
    }

    class Solution {
        /**
         * 方法一：备忘录自顶向下，递归求解
         *
         * @param text1
         * @param text2
         * @return
         */
        public int longestCommonSubsequence(String text1, String text2) {
            int[][] memory = new int[text1.length()][text2.length()];
            for (int i = 0; i < memory.length; i++) {
                Arrays.fill(memory[i], -1);
            }
            /*首先要明确dp函数的定义
             * 计算text1[i..] 和 text1[j..] 的最长公共子序列长度
             * 只有明确了dp函数定义，才能利用函数递归求解*/
            return dp(text1, 0, text2, 0, memory);
        }

        private int dp(String text1, int i, String text2, int j, int[][] memory) {
            /*基准条件
             * 如果当前递归比较的两个字符串的索引位置超过了最大长度，相当于空串了，最大公共子序列也就为0了，直接返回0*/
            if (i >= text1.length() || j >= text2.length())
                return 0;

            if (memory[i][j] != -1)
                return memory[i][j];

            /*如果当前i，j比较的两个字符相等，说明LCS包含当前的这个字符
             * LCS长度加一，然后i，j都前进一步，进行下一轮的比较*/
            if (text1.charAt(i) == text2.charAt(j)) {
                memory[i][j] = 1 + dp(text1, i + 1, text2, j + 1, memory);
            } else {
                /*return retMax(dp(text1, i + 1, text2, j),
                        dp(text1, i, text2, j + 1),
                        dp(text1, i + i, text2, j + 1));*/

                /*如果当前两个元素比较不相等，那么有可能text1[i]不在LCS中，
                 * 也有可能text2[j]不在LCS中
                 * 也有可能都不在LCS中
                 * 需要对这三种情况进行选择，取其中结果最大的那个
                 * 既然取最大值，那么第三种肯定小于另外两种，所以可省略*/
                memory[i][j] = Math.max(
                        dp(text1, i + 1, text2, j, memory),
                        dp(text1, i, text2, j + 1, memory)
                );
            }
            return memory[i][j];
        }

        private int retMax(int i, int j, int k) {
            return Math.max(Math.max(i, j), k);
        }

        /**
         * 方法二：动态规划，使用DP数组，自底向上迭代计算
         *
         * @param text1
         * @param text2
         * @return
         */
        public int longestCommonSubsequence2(String text1, String text2) {
            int m = text1.length();
            int n = text2.length();

            /*首先明确dp数组的定义
             * 它是存放text1[0..i-1] 和 text2[0..j-1] 的 lcs 长度，即 dp[i][j] 为当前长度的LCS的值
             * 一般dp数组的大小比字符串长度加一，因为要存放base case*/
            int[][] dp = new int[m + 1][n + 1];

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        /*当前比较的两个元素相等时，状态转移
                         * 那么当前LCS值即为上一轮比较的值+1*/
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        /*如果不相等，那么s1[i-1] 和 s2[j-1] 至少有一个不在 lcs 中 应该取最大值*/
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[m][n];
        }
    }
}
