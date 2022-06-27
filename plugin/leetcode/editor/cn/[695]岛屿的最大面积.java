
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 淹没岛屿，并更新最大岛屿面积
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        // 超出索引边界
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }
        // 已经是海水了
        if (grid[i][j] == 0) {
            return 0;
        }

        // 将 (i, j) 变成海水
        grid[i][j] = 0;
        //淹没与 (i, j) 相邻的陆地，并返回淹没的陆地面积
        return dfs(grid, i - 1, j)
                + dfs(grid, i + 1, j)
                + dfs(grid, i, j - 1)
                + dfs(grid, i, j + 1)
                + 1; // +1 是本身的（i，j）的面积
    }
}
//leetcode submit region end(Prohibit modification and deletion)
