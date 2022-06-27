
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePaths(int m, int n) {
        //如果只有一行或者一列，那么只有一种走法
        if (m == 1 || n == 1) return 1;
        //dp[i][j]定义：走到（i，j）位置一种有dp[i][j]种走法
        int[][] dp = new int[m][n];
        //第一列的所有位置一种走法
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        //第一行的所有位置也只有一种走法
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //当前位置可以从上往下走到达，也可以从左到右到达
                //所以当前位置的走法，是二者走法之和
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
