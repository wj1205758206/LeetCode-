
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        //旋转后的数组相当于划分成了 两个递增的部分
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                //这里为什么不 mid-1，是因为最小值会出现在有半部分的最低处，
                //如果mid恰好是最低点，那么-1就有可能跳过最小值，来到左半部分
                right = mid;
            } else {
                //left能+1，是因为最小值只会出现在有半部分，即使mid出现在了左半部分最高处，+1恰好就能落到右半部分的最低处
                left = mid + 1;
            }
        }
        return nums[right];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
