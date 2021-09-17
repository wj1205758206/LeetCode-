package codingoffer;

/**
 * 顺时针打印矩阵元素
 */
public class SpiralPrintMetric_29 {
    public static void main(String[] args) {
        Solution solution = new SpiralPrintMetric_29().new Solution();
        solution.spiralOrder(new int[][]{
                {1, 2, 3}, {4, 5, 6}, {7, 8, 9}
        });
    }

    class Solution {
        /**
         * 定义上下左右4个边界，然后模拟路径，逐个遍历
         *
         * @param matrix
         * @return
         */
        public int[] spiralOrder(int[][] matrix) {
            if (matrix.length == 0) return new int[0];
            int rows = matrix.length;
            int cols = matrix[0].length;
            int[] res = new int[rows * cols];
            int index = 0;
            int top = 0, left = 0, right = cols - 1, bottom = rows - 1;
            while (true) {
                for (int i = left; i <= right; i++) res[index++] = matrix[top][i];
                if (++top > bottom) break;

                for (int i = top; i <= bottom; i++) res[index++] = matrix[i][right];
                if (--right < left) break;

                for (int i = right; i >= left; i--) res[index++] = matrix[bottom][i];
                if (--bottom < top) break;

                for (int i = bottom; i >= top; i--) res[index++] = matrix[i][left];
                if (++left > right) break;
            }
            return res;
        }
    }
}
