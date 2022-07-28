
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int slow, fast;
        slow = fast = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++; //slow先向前走一步，因为至少保留一个重复的元素
                nums[slow] = nums[fast];
            }
            //fast做探测，用来寻找第一个与slow不重复的元素
            fast++;
        }
        return slow + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
