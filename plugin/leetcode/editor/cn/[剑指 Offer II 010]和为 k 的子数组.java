
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] preSum = null;

    public int subarraySum(int[] nums, int k) {
        preSum = new int[nums.length + 1];
        //先计算出前缀和
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int count = 0;
        //使用left right，遍历任意区间[left,right] 看看区间和是否有等于k的
        for (int left = 1; left < preSum.length; left++) {
            for (int right = left; right < preSum.length; right++) {
                if (preSum[right] - preSum[left - 1] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
