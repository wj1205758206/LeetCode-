package backtrace.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号匹配
 */
public class GenerateParentheses_22 {
    public static void main(String[] args) {

        Solution solution = new GenerateParentheses_22().new Solution();
        System.out.println(solution.generateParenthesis(3));
    }

    class Solution {
        List<String> result = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            if (n <= 0)
                return result;
            String track = "";

            //回溯    路径：track    选择列表：n个( 和 n个)
            //一个「合法」括号组合的左括号数量一定等于右括号数量
            //对于一个长度为n的括号字符串，其n-1长度字符串左括号数量一定大于等于右括号
            backtrack(track, n, n);

            return result;
        }

        private void backtrack(String track, int left, int right) {

            //不合法
            if (right < left)
                return;
            if (left < 0 || right < 0)
                return;

            //合法
            if (left == 0 && right == 0) {
                result.add(track);
                return;
            }

            //尝试放一个左括号
            track += "(";
            backtrack(track, left - 1, right);
            track = track.substring(0, track.length() - 1);

            //尝试放一个右括号
            track += ")";
            backtrack(track, left, right - 1);
            track = track.substring(0, track.length() - 1);
        }
    }
}
