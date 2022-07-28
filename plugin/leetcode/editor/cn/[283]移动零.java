
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        int slow, fast;
        slow = fast = 0;
        //使用快慢双指针，fast遇到不为0的将把这个元素提前到slow位置
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        //把所有不为0的元素都提前之后，剩余的元素全置为0
        for (; slow < nums.length; slow++) {
            nums[slow] = 0;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
