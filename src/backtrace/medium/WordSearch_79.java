package backtrace.medium;

/**
 * 单词搜索
 */
public class WordSearch_79 {
    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};

        Solution solution = new WordSearch_79().new Solution();
        System.out.println(solution.exist(board, "ABCCED"));
    }

    class Solution {
        public boolean exist(char[][] board, String word) {
            int rows = board.length;
            int cols = board[0].length;
            if (rows == 0)
                return false;

            //每次回溯需要选择方向，所以需要记录上下左右是否已经访问过
            boolean[][] visited = new boolean[rows][cols];

            //相当于选择列表，每一次的选择实际上是选择走的方向
            int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

            /*从每行每列挨个开始搜索，看有没有匹配的*/
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    /*进行回溯
                     * 路径：board和i、j坐标来表示当前路径
                     * 选择列表：上下左右选择其中一个方向继续回溯*/
                    if (backtrack(board, i, j, 0, word, visited, directions))
                        return true;
                }
            }

            return false;
        }

        private boolean backtrack(char[][] board, int x, int y, int start, String word, boolean[][] visited, int[][] directions) {

            //触发结束条件。如果当前回溯已经还剩最后一个字符没有匹配，则最后一个匹配关乎到底能不能匹配成功
            if (start == word.length() - 1)
                return board[x][y] == word.charAt(start);

            //寻找word匹配的起始位置
            if (board[x][y] == word.charAt(start)) {

                //找到开头，作出选择
                visited[x][y] = true;

                //选择列表：上下左右
                for (int[] direction : directions) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];

                    //新的坐标在棋盘范围内，并且是没有访问过的，则继续下一步的回溯
                    if (inValid(newX, newY, board) && !visited[newX][newY]) {
                        if (backtrack(board, newX, newY, start + 1, word, visited, directions))
                            return true;
                    }
                }

                //撤销选择
                visited[x][y] = false;

            }
            return false;
        }

        private boolean inValid(int x, int y, char[][] board) {
            return x >= 0 && x < board.length && y >= 0 && y < board[0].length;
        }
    }
}
