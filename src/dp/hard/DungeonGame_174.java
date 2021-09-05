package dp.hard;

import java.util.Arrays;

/**
 * 地下城游戏
 */
public class DungeonGame_174 {
    public static void main(String[] args) {
        int[][] dungeon = {
                {1, -4, 5, -99},
                {2, -2, -2, -1}
        };

        Solution solution = new DungeonGame_174().new Solution();
        System.out.println(solution.calculateMinimumHP2(dungeon));

    }

    class Solution {
        /**
         * 方法一：动态规划，自顶向下递归计算
         *
         * @param dungeon
         * @return
         */
        public int calculateMinimumHP(int[][] dungeon) {
            int m = dungeon.length;
            int n = dungeon[0].length;
            int[][] memory = new int[m][n];
            for (int[] mem : memory) {
                Arrays.fill(mem, -1);
            }

            /*题目让求到达右下角，左上角起点至少需要多少生命值
             * 这里固定点是终点，让求的是起点的状态变化
             * 我们应该定义dp为(i，j)到达右下角至少需要dp(i,j)生命值，这样定义我们可以知道(i,j)点的生命值，逐步逼近(0,0)起点
             * 不应该定义为从(0,0)开始，到达(i,j)这个点至少需要dp(i,j)生命值，这样定义会导致无法得到达到(i,j)点的生命值，也就无法进一步退出下一步
             * 应该采用倒着推，逼近起点的方法*/
            return dp(dungeon, 0, 0, memory);
        }

        private int dp(int[][] dungeon, int i, int j, int[][] memory) {
            if (i == dungeon.length - 1 && j == dungeon[0].length - 1)
                return dungeon[i][j] >= 0 ? 1 : -dungeon[i][j] + 1;

            if (i >= dungeon.length || j >= dungeon[0].length)
                return Integer.MAX_VALUE;

            if (memory[i][j] != -1)
                return memory[i][j];

            memory[i][j] = Math.min(
                    dp(dungeon, i + 1, j, memory),
                    dp(dungeon, i, j + 1, memory))
                    - dungeon[i][j];

            memory[i][j] = memory[i][j] <= 0 ? 1 : memory[i][j];

            return memory[i][j];
        }

        /**
         * 方法二：动态规划，自底向上使用DP表迭代计算
         *
         * @param dungeon
         * @return
         */
        public int calculateMinimumHP2(int[][] dungeon) {
            int m = dungeon.length;
            int n = dungeon[0].length;
            int[][] dp = new int[m][n];

            dp[m - 1][n - 1] = dungeon[m - 1][n - 1] > 0 ? 1 : -dungeon[m - 1][n - 1] + 1;
            for (int i = m - 2; i >= 0; i--) {
                dp[i][n - 1] = (dp[i + 1][n - 1] - dungeon[i][n - 1] > 0) ? dp[i + 1][n - 1] - dungeon[i][n - 1] : 1;

            }
            for (int j = n - 2; j >= 0; j--) {
                dp[m - 1][j] = (dp[m - 1][j + 1] - dungeon[m - 1][j]) > 0 ? dp[m - 1][j + 1] - dungeon[m - 1][j] : 1;
            }

            for (int i = m - 2; i >= 0; i--) {
                for (int j = n - 2; j >= 0; j--) {
                    dp[i][j] = (Math.min(
                            dp[i + 1][j],
                            dp[i][j + 1]
                    ) - dungeon[i][j]) > 0
                            ?
                            Math.min(
                                    dp[i + 1][j],
                                    dp[i][j + 1]
                            ) - dungeon[i][j]
                            :
                            1;
                }
            }
            for (int i = 0; i < dp.length; i++) {
                for (int j : dp[i]) {
                    System.out.print(j + " ");
                }
                System.out.println();
            }
            return dp[0][0] > 0 ? dp[0][0] : 1;
        }
    }
}
