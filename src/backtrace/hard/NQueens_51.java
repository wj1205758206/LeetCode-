package backtrace.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后问题
 */
public class NQueens_51 {
    public static void main(String[] args) {
        int n = 4;

        Solution solution = new NQueens_51().new Solution();
        System.out.println(solution.solveNQueens(n).toString());
    }

    class Solution {
        List<List<String>> result = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {

            /*初始化棋盘*/
            List<List<String>> board = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                List<String> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(".");
                }
                board.add(row);
            }

            /*回溯，
             * 路径：board 是整个棋盘
             * 选择列表：row 棋盘中剩下的行*/
            backtrace(board, 0);

            return result;
        }

        private void backtrace(List<List<String>> board, int row) {
            /*触发结束条件
             * 当row达到棋盘最后一行，就将当前棋盘的摆列当做一种可能性解法，存放到结果集中
             * 需要注意整理输出做了特殊处理，相当于把二维棋盘压缩成一维当做一种解法*/
            if (row == board.size()) {
                List<String> toList = toListString(board);
                result.add(new ArrayList<>(toList));
                return;
            }

            int n = board.get(row).size();
            for (int col = 0; col < n; col++) {
                /*剪枝函数，排除掉不合法的选择*/
                if (!isValid(board, row, col))
                    continue;

                //做出选择
                board.get(row).remove(col);
                board.get(row).add(col, "Q");

                /*继续下一层的回溯*/
                backtrace(board, row + 1);

                //撤销选择
                board.get(row).remove(col);
                board.get(row).add(col, ".");

            }
        }

        private List<String> toListString(List<List<String>> board) {
            List<String> ans = new ArrayList<>();
            for (List<String> stringList : board) {
                String temp = "";
                for (String s : stringList) {
                    temp += s;
                }
                ans.add(temp);
            }
            return ans;
        }

        private boolean isValid(List<List<String>> board, int row, int col) {
            int n = board.size();

            //遍历每一排，检查当前列上是否已经有皇后了
            for (int i = 0; i < n; i++) {
                if (board.get(i).get(col) == "Q")
                    return false;
            }

            //检查当前落点的左上方斜线是否已经有皇后了
            for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
                if (board.get(i).get(j) == "Q")
                    return false;
            }

            //检查当前落点的右上方斜线是否已经有皇后了
            for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
                if (board.get(i).get(j) == "Q")
                    return false;
            }
            return true;
        }
    }
}
