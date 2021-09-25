package codingoffer;

/**
 * 礼物的最大价值(dp/回溯/备忘录递归)
 */
public class MaxValueOfGifts_47 {
    public static void main(String[] args) {
        Solution solution = new MaxValueOfGifts_47().new Solution();
        System.out.println(solution.maxValue3(new int[][]{
                {1, 2, 1},
                {3, 2, 1},

        }));
    }

    class Solution {
        /**
         * 动态规划
         *
         * @param grid
         * @return
         */
        public int maxValue(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int[][] dp = new int[m][n];
            dp[0][0] = grid[0][0];
            for (int i = 1; i < m; i++) {
                dp[i][0] = grid[i][0] + dp[i - 1][0];
            }
            for (int j = 1; j < n; j++) {
                dp[0][j] = grid[0][j] + dp[0][j - 1];
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
                }
            }
            return dp[m - 1][n - 1];
        }

        int result = -1;
        int[][] directs = new int[][]{
                {1, 0},//向右走
                {0, 1}  //向下走
        };

        /**
         * 回溯
         *
         * @param grid
         * @return
         */
        public int maxValue2(int[][] grid) {
            if (grid.length == 0) return -1;
            int track = grid[0][0];
            int m = grid.length;
            int n = grid[0].length;
            backtrack(grid, m, n, 0, 0, track);
            return result;
        }

        private void backtrack(int[][] grid, int m, int n, int x, int y, int track) {
            if (x >= m) return;
            if (y >= n) return;

            if (x == m - 1 && y == n - 1) {
                result = Math.max(result, track);
            }

            for (int[] direct : directs) {
                int newX = x + direct[0];
                int newY = y + direct[1];
                if (isValid(newX, newY, grid)) {
                    track += grid[newX][newY];
                    backtrack(grid, m, n, newX, newY, track);
                    track -= grid[newX][newY];
                }
            }
        }

        private boolean isValid(int x, int y, int[][] grid) {
            return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
        }

        /**
         * 备忘录 + 递归
         *
         * @param grid
         * @return
         */
        public int maxValue3(int[][] grid) {
            if (grid.length == 0) return -1;
            int m = grid.length;
            int n = grid[0].length;
            int[][] memory = new int[m][n];
            return DFS(grid, m, n, 0, 0, memory);
        }

        private int DFS(int[][] grid, int m, int n, int i, int j, int[][] memory) {
            if (i >= m || j >= n) return 0;

            if (memory[i][j] != 0) return memory[i][j];

            return grid[i][j] + Math.max(DFS(grid, m, n, i + 1, j, memory), DFS(grid, m, n, i, j + 1, memory));
        }
    }
}
