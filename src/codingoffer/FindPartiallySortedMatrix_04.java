package codingoffer;

/**
 * 二维数组中的查找
 */
public class FindPartiallySortedMatrix_04 {
    public static void main(String[] args) {

    }

    class Solution {
        /**
         * 二维数组，从左到右，从上到下，递增，查找目标值
         * 【从左下角或者右上角开始做判断】
         * 之所以不能从左上角或者右下角开始做判断，是因为比较一旦不相等，就会有两种选择
         *
         * @param matrix
         * @param target
         * @return
         */
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix.length == 0) return false;
            int m = matrix.length;
            int n = matrix[0].length;
            int i = 0;
            int j = n - 1;

            while (i < m && j >= 0) {
                if (matrix[i][j] == target)
                    return true;
                if (matrix[i][j] > target) {
                    j--;
                } else {
                    i++;
                    for (int k = i; k < m; k++) {
                        if (matrix[k][j] == target)
                            return true;
                    }
                }
            }
            return false;
        }
    }
}
