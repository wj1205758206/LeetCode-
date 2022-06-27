
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0 || nums == null) return 0;
        int result = nums[0];
        //两个mDP分别定义为以i结尾的子数组的最大积与最小积；
        //因为最大值有可能负负得正，也有可能正正得正，所以得维护最大值和最小值
        int[] maxDP = new int[nums.length];
        int[] minDP = new int[nums.length];
        maxDP[0] = minDP[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            //计算最大值，与自身比较，是因为有可能自身是正数，之前的都是0
            //如果自身是负数，取min相乘，负负得正
            //如果自身是正数，取max相乘，正正得正
            maxDP[i] = Math.max(nums[i],
                    Math.max(maxDP[i - 1] * nums[i], minDP[i - 1] * nums[i]));
            minDP[i] = Math.min(nums[i],
                    Math.min(maxDP[i - 1] * nums[i], minDP[i - 1] * nums[i]));
            result = Math.max(result, maxDP[i]);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
