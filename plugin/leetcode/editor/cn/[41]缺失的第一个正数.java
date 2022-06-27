
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        //值配其位，相当于对数组中的值做了一个排序，值为 i 的元素要放在 i-1 索引的位置
        for (int i = 0; i < len; i++) {
            // 当前元素值num[i]在[1，len]之间时，并且 值不配位 时，才交换
            while (nums[i] > 0 && nums[i] <= len
                    && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        // 再次遍历 看看哪个值不配位
        for (int i = 0; i < len; i++) {
            //第一个值不配位的元素就是要找的那个最小正整数
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        //有可能都值配其位，那么缺失的就是len+1
        return len + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
