
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int result = -1;

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    //子序列的问题，允许间断，所以取max
                    //dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    //子数组或者子串问题，必须是连续的，如果当前两个元素不相等，则置为0，相当于重新开始计算
                    dp[i][j] = 0;
                }
                //始终取最大值
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
