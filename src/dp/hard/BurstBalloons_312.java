package dp.hard;

/**
 * 戳气球
 */
public class BurstBalloons_312 {
    public static void main(String[] args) {
        Solution solution = new BurstBalloons_312().new Solution();
        System.out.println(solution.maxCoins(new int[]{3, 1, 5, 8}));
    }

    class Solution {

        public int maxCoins(int[] nums) {
            int n = nums.length;
            int[] points = new int[n + 2];
            points[0] = points[n + 1] = 1;
            for (int i = 1; i <= n; i++) {
                points[i] = nums[i - 1];
            }

            /*dp[i][j] = x表示，戳破气球i和气球j之间（开区间，不包括i和j）的所有气球，可以获得的最高分数为x*/
            int[][] dp = new int[n + 2][n + 2];

            /*状态：i和j
            * 选择：最后戳破（i，j）之间的哪个气球k
            * 最后求得应该是dp[0][n+1],在二维dp的右上角
            * 所以， i 应该从下往上，j应该从左往右*/
            for (int i = n; i >= 0; i--) {
                for (int j = i + 1; j < n + 2; j++) {
                    // 最后戳破的气球是哪个？
                    for (int k = i + 1; k < j; k++) {
                        dp[i][j] = Math.max(
                                dp[i][j],
                                dp[i][k] + dp[k][j] + points[i] * points[k] * points[j]
                        );
                    }
                }
            }
            return dp[0][n + 1];
        }
    }
}
