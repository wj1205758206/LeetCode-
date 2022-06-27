
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        int i, j, k;
        i = nums.length - 2;
        j = k = nums.length - 1;
        //从后向前 查找第一个 相邻升序 的元素对 (i,j)
        while (i >= 0 && nums[i] >= nums[j]) {
            i--;
            j--;
        }
        //如果是i == -1了，极端情况，说明数组整体是逆序,如[5，4，3，2，1]
        if (i >= 0) {
            //从后向前找，找到尽可能小 且 大于i 的数
            while (nums[i] >= nums[k]) {
                k--;
            }
            //交换，相当于选择尽可能小的数，来替换整数中的高位数，才能保证整体的数值最小，即满足 下一个更大 的含义
            swap(nums, i, k);
        }
        //最后还需要翻转[j，length-1]范围的数值，翻转成升序，即也是保证高位数的数值较小
        reverse(nums, j, nums.length - 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
