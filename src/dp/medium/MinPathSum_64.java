package dp.medium;

import java.util.Arrays;

/**
 * 最小路径和
 */
public class MinPathSum_64 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
        };

        Solution solution = new MinPathSum_64().new Solution();
        System.out.println(solution.minPathSum2(grid));
    }

    class Solution {
        /**
         * 方法一：动态规划，自顶向下递归计算
         *
         * @param grid
         * @return
         */
        public int minPathSum(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] memory = new int[m][n];

            for (int[] mem : memory) {
                Arrays.fill(mem, Integer.MAX_VALUE);
            }

            /*明确dp函数定义
             * 在grid二维数组中，想要走到grid[i][j]位置的最小路径和为dp(i,j)*/
            return dp(grid, m - 1, n - 1, memory);
        }

        private int dp(int[][] grid, int i, int j, int[][] memory) {
            /*基准条件
             * 从左上角开始*/
            if (i == 0 && j == 0)
                return grid[0][0];

            /*由于自顶向下，i，j不断递减1，容易超出边界
             * 超出边界是我们直接返回一个较大的值即可，这样就会放弃这个选择*/
            if (i < 0 || j < 0)
                return Integer.MAX_VALUE;

            if (memory[i][j] != Integer.MAX_VALUE)
                return memory[i][j];

            /*选择到底是向下走还是向右走到达ij位置的路径和最小，然后在加上ij位置元素，即为总的最小路径和*/
            memory[i][j] = Math.min(dp(grid, i - 1, j, memory), dp(grid, i, j - 1, memory)) + grid[i][j];

            return memory[i][j];
        }

        /**
         * 方法二：动态规划，使用dp表，自底向上迭代计算
         *
         * @param grid
         * @return
         */
        public int minPathSum2(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];

            /*基准条件
             * 初始化左上角第一个值，然后迭代计算第一行和第一列的值*/
            dp[0][0] = grid[0][0];
            for (int i = 1; i < m; i++) {
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }
            for (int j = 1; j < n; j++) {
                dp[0][j] = dp[0][j - 1] + grid[0][j];
            }

            /*从第二行和第二列开始迭代计算*/
            for (int i = 1; i < dp.length; i++) {
                for (int j = 1; j < dp[0].length; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
            return dp[m - 1][n - 1];
        }
    }
}
