package backtrace.hard;

/**
 * 解数独
 */
public class SudokuSolver_37 {
    public static void main(String[] args) {

    }

    class Solution {
        /**
         * 回溯
         *
         * @param board
         */
        public void solveSudoku(char[][] board) {

            //路径：board棋盘 结合ij行列坐标   选择列表是1~9
            backtrace(board, 0, 0);

        }

        private boolean backtrace(char[][] board, int i, int j) {
            //棋盘9X9
            int m = 9, n = 9;

            //如果当前行数到达最底层，说明找到了一个解，无需继续遍历，直接返回true即可
            if (i == m)
                return true;

            //如果列到达了最右侧，那么就从下一行开头继续回溯
            if (j == n)
                return backtrace(board, i + 1, 0);

            //如果是棋盘预设的数字，不用管，继续回溯下一个位置即可
            if (board[i][j] != '.')
                return backtrace(board, i, j + 1);

            //从选择列表中做出选择
            for (char c = '1'; c <= '9'; c++) {
                //剪枝操作，排除掉不合法的数字
                if (!isValid(board, i, j, c))
                    continue;

                //作出选择
                board[i][j] = c;

                //继续下一层的回溯
                if (backtrace(board, i, j + 1))
                    return true;

                //撤销选择
                board[i][j] = '.';
            }

            //穷举1~9还没有返回，说明找不到可行解
            return false;
        }

        private boolean isValid(char[][] board, int row, int col, char c) {
            for (int i = 0; i < 9; i++) {
                //判断当前行是否存在重复元素
                if (board[row][i] == c)
                    return false;
                //判断当前列是否存在重复元素
                if (board[i][col] == c)
                    return false;
                //判断3X3方框是否存在重复元素
                if (board[(row / 3) * 3 + i / 3][(col / 3) * 3 + i % 3] == c)
                    return false;
            }
            return true;
        }
    }
}
