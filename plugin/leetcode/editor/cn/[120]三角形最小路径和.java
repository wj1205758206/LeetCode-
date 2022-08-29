
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < dp.length; i++) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                if (j - 1 < 0) {
                    dp[i][j] = dp[i-1][j] + row.get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1])
                            + row.get(j);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < dp[n - 1].length; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
