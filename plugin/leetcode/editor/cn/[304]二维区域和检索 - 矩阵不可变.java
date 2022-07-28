
//leetcode submit region begin(Prohibit modification and deletion)
class NumMatrix {
    int[][] preSum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        // 定义：preSum[i][j] 记录从第一行第一列开始到第i行第j列 所有元素和
        // 即 matrix 中子矩阵 [0, 0, i-1, j-1] 的元素和
        preSum = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 计算每个矩阵 [0, 0, i, j] 的元素和
                preSum[i][j] = preSum[i][j - 1]
                        + preSum[i - 1][j]
                        + matrix[i - 1][j - 1]
                        - preSum[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // 目标矩阵之和由四个相邻矩阵运算获得
        return preSum[row2 + 1][col2 + 1]
                - preSum[row1][col2 + 1]
                - preSum[row2 + 1][col1]
                + preSum[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)
