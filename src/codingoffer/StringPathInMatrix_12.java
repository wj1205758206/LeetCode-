package codingoffer;

/**
 * 矩阵中的路径(单词搜索)
 */
public class StringPathInMatrix_12 {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        Solution solution = new StringPathInMatrix_12().new Solution();
        System.out.println(solution.exist(board, "ABCCED"));
    }

    class Solution {
        int[][] directs = {
                {-1, 0},
                {0, 1},
                {1, 0},
                {0, -1}
        };
        boolean[][] used;
        int rows;
        int cols;

        public boolean exist(char[][] board, String word) {
            if (board.length == 0) return false;
            rows = board.length;
            cols = board[0].length;
            used = new boolean[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (backtrack(board, i, j, word, 0))
                        return true;
                }
            }
            return false;
        }

        private boolean backtrack(char[][] board, int x, int y, String word, int start) {
            if (start == word.length() - 1)
                return board[x][y] == word.charAt(start);

            if (board[x][y] == word.charAt(start)) {

                used[x][y] = true;

                for (int[] direct : directs) {
                    int newX = x + direct[0];
                    int newY = y + direct[1];
                    if (isValid(newX, newY) && !used[newX][newY]) {
                        if (backtrack(board, newX, newY, word, start + 1))
                            return true;
                    }
                }

                used[x][y] = false;
            }

            return false;
        }

        private boolean isValid(int x, int y) {
            return x >= 0 && x < rows && y >= 0 && y < cols;
        }
    }
}
