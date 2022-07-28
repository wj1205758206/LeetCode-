
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> track = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);  // 先排序，让相同的元素靠在一起
        backtrack(nums, 0);
        return result;
    }

    public void backtrack(int[] nums, int start) {
        result.add(new ArrayList<>(track));

        for (int i = start; i < nums.length; i++) {
            // 剪枝逻辑，值相同的相邻树枝，只遍历第一条
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            track.add(nums[i]);
            backtrack(nums, i + 1);
            track.remove(track.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
