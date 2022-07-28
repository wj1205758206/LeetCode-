
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> track = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums);
        return result;
    }

    public void backtrack(int[] nums) {
        if (track.size() == nums.length) {
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            //多判断一次  i-1是否被访问过，如果没有被访问过，那么选i-i还是i都是一样的
            //我们需要的是固定好顺序的，也就是i-1如果被访问了，即使i是一样的元素，也需要保留
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            if (used[i]) continue;

            used[i] = true;
            track.add(nums[i]);
            backtrack(nums);
            track.remove(track.size() - 1);
            used[i] = false;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
