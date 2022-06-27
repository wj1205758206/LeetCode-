
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> track = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) return result;
        //先进行升序排序
        Arrays.sort(candidates);
        backtrack(candidates, target, 0, 0);
        return result;
    }

    public void backtrack(int[] candidates, int target, int sum, int start) {
        //找到一组sum = target
        if (sum == target) {
            result.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            //剪枝：
            // 1.大于target跳过
            // 2.如果有重复元素且可重复选择，我们可以判断 i 和 i-1元素是否重复，进而选择跳过
            if (candidates[start] + sum > target) continue;
            if (i > start && candidates[i - 1] == candidates[i]) continue;

            track.add(candidates[i]);
            sum += candidates[i];
            // 组合有顺序无关，用start来控制(i+1),又因为可重复选择，可让start=i
            backtrack(candidates, target, sum, i);
            sum -= candidates[i];
            track.remove(track.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
