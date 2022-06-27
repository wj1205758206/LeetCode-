
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        //从右上角开始找，向左变小 ，向下变大
        int i = 0, j = n - 1;
        while (i < m && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            //如果小于target，向下找
            if (matrix[i][j] < target) {
                i++;
            } else {
                //如果大于target，向左找
                j--;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
