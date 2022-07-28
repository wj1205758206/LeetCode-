
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int num = 1;
        while (num <= n * n) {
            if (top <= bottom) {
                for (int j = left; j <= right; j++) {
                    matrix[top][j] = num++;
                }
                top++;
            }
            if (left <= right) {
                for (int i = top; i <= bottom; i++) {
                    matrix[i][right] = num++;
                }
                right--;
            }
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    matrix[bottom][j] = num++;
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    matrix[i][left] = num++;
                }
                left++;
            }
        }
        return matrix;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
