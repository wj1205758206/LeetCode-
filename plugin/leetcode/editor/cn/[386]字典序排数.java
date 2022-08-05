
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<Integer> result = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i <= 9; i++) {
            dfs(i, n);
        }
        return result;
    }

    public void dfs(int cur, int limit) {
        if (cur > limit) return;

        result.add(cur);

        for (int i = 0; i <= 9; i++) {

            dfs(cur * 10 + i, limit);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
