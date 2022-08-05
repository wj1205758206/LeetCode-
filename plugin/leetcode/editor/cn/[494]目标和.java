
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap<String, Integer> mem = new HashMap<>();

    public int findTargetSumWays(int[] nums, int target) {
        return dp(nums, 0, 0, target);
    }

    public int dp(int[] nums, int start, int sum, int target) {
        if (start == nums.length) {
            return sum == target ? 1 : 0;
        }

        String key = start + "," + sum;
        if (mem.containsKey(key)) {
            return mem.get(key);
        }

        int result = dp(nums, start + 1, sum + nums[start], target)
                + dp(nums, start + 1, sum - nums[start], target);

        mem.put(key, result);

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
