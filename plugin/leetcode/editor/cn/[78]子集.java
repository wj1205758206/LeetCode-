
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> track = new ArrayList<>();
        if (nums.length == 0 || nums == null) return result;
        //通过 start 参数控制树枝的遍历，避免产生重复的子集
        backtrack(nums, track, 0);
        return result;
    }

    public void backtrack(int[] nums, List<Integer> track, int start) {
        // 前序位置，每个节点的值都是一个子集，一开始add的是一个空集[]
        result.add(new ArrayList<>(track));

        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.add(nums[i]);
            // 继续下一层的节点
            backtrack(nums, track, i + 1);
            // 撤销选择
            track.remove(track.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
