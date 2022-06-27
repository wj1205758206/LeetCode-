
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) return result;
        String track = "";
        backtrack(track, n, n);
        return result;
    }

    public void backtrack(String track, int left, int right) {
        //剪枝：一定是 ）结尾，所以剩余的 ）数量要大于 （ 数量
        if (left < right) {
            return;
        }
        //剪枝：（ ）剩余的数量都必须大于0
        if (left < 0 || right < 0) {
            return;
        }

        //恰好（ ） 的数量都用完了，则说明找到了一个符合条件的组合
        if (left == 0 && right == 0) {
            result.add(track);
            return;
        }

        //尝试选择 （
        track += "(";
        backtrack(track, left - 1, right);
        track = track.substring(0, track.length() - 1);

        //尝试选择 ）
        track += ")";
        backtrack(track, left, right - 1);
        track = track.substring(0, track.length() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
