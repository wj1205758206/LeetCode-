
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> track = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(n, k, 1);
        return result;
    }

    public void backtrack(int n, int k, int start) {
        if (k == track.size()) {
            result.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            track.add(i);
            backtrack(n, k, i + 1);
            track.remove(track.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
