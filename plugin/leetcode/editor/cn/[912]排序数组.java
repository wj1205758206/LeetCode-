
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        // 排序整个数组（原地修改）
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        // 对 nums[lo..hi] 进行切分
        // 使得 nums[lo..p-1] <= nums[p] < nums[p+1..hi]
        int p = partition(nums, left, right);

        //递归排序左右部分
        quickSort(nums, left, p - 1);
        quickSort(nums, p + 1, right);
    }

    public int partition(int[] nums, int left, int right) {
        int num = nums[left];
        int i = left + 1;
        int j = right;
        while (i <= j) {
            while (i < j && nums[i] <= num) i++;
            while (j > left && nums[j] > num) j--;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, left, j);
        return j; //返回本次排序，该元素所在索引位置
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
