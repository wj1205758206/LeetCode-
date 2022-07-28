
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int count = 0;

    public int reversePairs(int[] nums) {
        if (nums.length == 0) return 0;
        sort(nums, 0, nums.length - 1);
        return count;
    }

    public void sort(int[] nums, int left, int right) {
        int mid = (left + right) / 2;
        if (left < right) {
            sort(nums, left, mid);
            sort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    public void merge(int[] nums, int left, int mid, int right) {
        int index = 0;
        int[] temp = new int[right - left + 1];
        int p = left, q = mid + 1;
        while (p <= mid && q <= right) {
            //temp始终存放较小的那个数，里面的数从小到大排序
            if (nums[p] <= nums[q]) {
                temp[index++] = nums[p++];
            } else {
                //即使基于归并排序的基础上，加了一行统计逆序对的代码
                count += mid - p + 1; //如果出现了左边数组大于右边的数，那么左边数组 剩余的 都是比右边数组大的数
                temp[index++] = nums[q++];
            }
        }
        //右边遍历完事了   可能左边还剩
        while (p <= mid) {
            temp[index++] = nums[p++];
        }
        //左边遍历完事了   可能右边还剩
        while (q <= right) {
            temp[index++] = nums[q++];
        }
        //将排序好的temp复制回nums中
        for (int i = 0; i < temp.length; i++) {
            nums[left + i] = temp[i];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
