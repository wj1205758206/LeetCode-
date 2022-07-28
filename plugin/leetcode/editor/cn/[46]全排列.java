
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> track = new ArrayList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];

        backtrack(nums);

        return result;
    }

    public void backtrack(int[] nums) {
        if (track.size() == nums.length) {
            result.add(new ArrayList<>(track));
            return;
        }

        //排列跟元素顺序有关，不能使用start来控制了，start控制回溯只能往右走
        //排列存在往回走的情况，所以不能使用start单向控制，所以改用used，每一都从头走，看看是否访问过
        for (int i = 0; i < nums.length; i++) {
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
