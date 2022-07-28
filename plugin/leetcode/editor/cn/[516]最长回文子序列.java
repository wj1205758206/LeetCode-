
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = 1;
        }

        //i由下向上，j是由左至右 去遍历计算左对角线右上方部分
        for (int i = dp.length - 1; i >= 0; i--) {
            //j=i+1，左对角线右侧
            for (int j = i + 1; j < dp.length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    // s[i][j]的上一层是s[i+1][j-1]，相当于从中心向两边探索
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    //不相等，判断s[i+1..j] 和 s[i..j-1] 谁的回文子序列更长
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        //相当于返回s[0][n-1],整个字符串中最长的回文子序列，
        return dp[0][dp.length - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
