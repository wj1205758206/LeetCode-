
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] directs = new int[][]{
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
    };
    int rows;
    int cols;
    boolean[][] used;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        used = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtrack(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, int x, int y, String word, int start) {
        if (start == word.length() - 1) {
            return board[x][y] == word.charAt(start);
        }

        if (board[x][y] == word.charAt(start)) {

            used[x][y] = true;

            for (int i = 0; i < directs.length; i++) {
                int newX = directs[i][0] + x;
                int newY = directs[i][1] + y;
                if (isValid(newX, newY) && used[newX][newY] == false) {
                    if (backtrack(board, newX, newY, word, start + 1)) {
                        return true;
                    }
                }
            }

            used[x][y] = false;
        }

        return false;
    }

    public boolean isValid(int x, int y) {
        if (x >= 0 && x < rows && y >= 0 && y < cols) {
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
