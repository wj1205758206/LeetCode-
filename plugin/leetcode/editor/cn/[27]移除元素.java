
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeElement(int[] nums, int val) {
        int slow, fast;
        slow = fast = 0;
        //使用快慢双指针，将不是val的元素提前放到slow位置
        while (fast < nums.length) {
            if (nums[fast] != val){
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
