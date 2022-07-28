
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> track = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates, 0, target);
        return result;
    }

    public void backtrack(int[] candidates, int start, int target) {
        if (sum == target) {
            result.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (sum + candidates[i] > target) {
                continue;
            }

            track.add(candidates[i]);
            sum += candidates[i];
            backtrack(candidates, i + 1, target);
            sum -= candidates[i];
            track.remove(track.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
