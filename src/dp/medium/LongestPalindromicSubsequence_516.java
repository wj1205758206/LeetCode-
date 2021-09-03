package dp.medium;

import java.util.Arrays;

/**
 * 最长回文子序列
 */
public class LongestPalindromicSubsequence_516 {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubsequence_516().new Solution();
        System.out.println(solution.longestPalindromeSubseq("cbbd"));
    }

    class Solution {
        public int longestPalindromeSubseq(String s) {
            int[][] dp = new int[s.length()][s.length()];

            for (int[] row : dp) {
                Arrays.fill(row, 0);
            }

            for (int i = 0; i < dp.length; i++) {
                dp[i][i] = 1;
            }

            for (int i = dp.length - 1; i >= 0; i--) {
                for (int j = i + 1; j < dp.length; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    }
                }
            }
            return dp[0][dp.length - 1];
        }
    }
}
