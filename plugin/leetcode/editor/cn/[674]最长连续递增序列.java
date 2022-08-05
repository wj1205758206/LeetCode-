
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int start = 0;
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
