package dp.medium;

import java.util.Arrays;

/**
 * 下降路径最小和
 */
public class MinFallingPathSum_931 {
    public static void main(String[] args) {
        int[][] matrix = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};

        Solution solution = new MinFallingPathSum_931().new Solution();
        System.out.println(solution.minFallingPathSum(matrix));
    }

    class Solution {
        int[][] memory;

        public int minFallingPathSum(int[][] matrix) {

            int row = matrix.length;
            int col = row;

            memory = new int[row][col];
            for (int i = 0; i < memory.length; i++) {
                //初始化备忘录，初始值应选择特殊值，一般选择测试用例范围之内的数
                Arrays.fill(memory[i], 200000);
            }

            int result = Integer.MAX_VALUE;

            /*题目要求到最后一行，但没有规定到最后一行的哪一列
             * 所以，需要遍历每一列，再求最后一行的每一列的最小值*/
            for (int i = 0; i < col; i++) {
                /*dp来求最后一行的任意一列的路径最小和*/
                result = Math.min(result, dp(matrix, row - 1, i));
            }

            return result;
        }

        private int dp(int[][] matrix, int row, int col) {

            //基准条件，索引超出nXn的返回，就返回特殊值，这个特殊值一般选择测试用例范围之外的值
            if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length)
                return 100000;

            //考虑到第一行的路径最小和，即起点和落点在同一行
            if (row == 0)
                return matrix[row][col];

            //使用备忘录减少计算
            if (memory[row][col] != 200000)
                return memory[row][col];

            /*对于 matrix[i][j]，只有可能从 matrix[i-1][j], matrix[i-1][j-1], matrix[i-1][j+1] 这三个位置转移过来
             * 再加上matrix[i][j]就可计算出到matrix[i][j]路径最小和*/
            memory[row][col] = matrix[row][col] +
                    Math.min(
                            Math.min(dp(matrix, row - 1, col - 1), dp(matrix, row - 1, col)),
                            dp(matrix, row - 1, col + 1));

            return memory[row][col];
        }
    }
}
