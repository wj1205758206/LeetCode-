
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] mem;

    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        mem = new int[rows][cols];
        for (int[] row : mem) {
            Arrays.fill(row, 666666);
        }

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < cols; j++) {
            res = Math.min(res, dp(matrix, rows - 1, j));
        }
        return res;
    }

    public int dp(int[][] matrix, int i, int j) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return 999999;
        }
        if (i == 0) {
            return matrix[0][j];
        }
        if (mem[i][j] != 666666) {
            return mem[i][j];
        }

        mem[i][j] = getMin(dp(matrix, i - 1, j), dp(matrix, i - 1, j - 1), dp(matrix, i - 1, j + 1))
                + matrix[i][j];
        return mem[i][j];
    }

    public int getMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
