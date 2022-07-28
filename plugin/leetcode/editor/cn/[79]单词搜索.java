
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] directs = {
            {-1, 0}, //上
            {1, 0}, //下
            {0, -1}, //左
            {0, 1} //右
    };
    int rows;
    int cols;
    boolean[][] used;

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) return false;
        rows = board.length;
        cols = board[0].length;
        used = new boolean[rows][cols];
        //尝试以不同的起点进行回溯遍历，看是否存在word
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //如果当前起点回溯找到了word，就返回true
                if (backtrack(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, int x, int y, String word, int index) {
        //如果当前回溯匹配到了word最后一个字符，只需判断最后一个字符是否也匹配，如果是，这说明找到了word
        if (index == word.length() - 1) {
            return board[x][y] == word.charAt(index);
        }
        //只有当网格字符等于当前index对应的字符时，才有必要往下回溯匹配
        if (word.charAt(index) == board[x][y]) {
            used[x][y] = true;

            //继续回溯时，需要做选择，也就是选择下一步走的方向
            for (int[] direct : directs) {
                int newX = x + direct[0];
                int newY = y + direct[1];
                //只有当新坐标有效 并且 没有访问过时，才继续回溯
                if (isVaild(newX, newY) && used[newX][newY] == false) {
                    if (backtrack(board, newX, newY, word, index + 1)) {
                        return true;
                    }
                }
            }

            used[x][y] = false;
        }
        return false;
    }

    public boolean isVaild(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
