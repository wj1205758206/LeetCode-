
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0;
        int n = nums.length;
        int sum = 1;
        int count = 0;

        if (k <= 1) return 0;

        for (; right < n; right++){
            sum *= nums[right];
            while (sum>=k){
                sum /= nums[left];
                left++;
            }
            count += right-left+1;
        }
//        while (right < n) {
//            sum *= nums[right];
//
//            while (sum >= k) {
//                sum /= nums[left];
//                left++;
//            }
//
//            count += right - left + 1;
//
//            right++;
//        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
