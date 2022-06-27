
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 2; // -2 是因为防止mid+1越界
        while (left <= right) {
            int mid = (left + right) / 2;
            //比较 mid 与 mid+1 的值，如果 mid+1 较大，则右侧存在峰值
            // 趋势呈现上升状态，峰值出现在右边，所以  扩大左边界
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else if (nums[mid] >= nums[mid + 1]) {
                //比较 mid 与 mid+1 的值，如果 mid 较大，则左侧存在峰值
                // 趋势呈现下降状态，峰值出现在左边，所以  缩小右边界
                right = mid - 1;
            }
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
