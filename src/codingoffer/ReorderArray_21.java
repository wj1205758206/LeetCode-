package codingoffer;

/**
 * 调整数组顺序使奇数位于偶数前面
 */
public class ReorderArray_21 {
    public static void main(String[] args) {
        Solution solution = new ReorderArray_21().new Solution();
        int[] exchange = solution.exchange(new int[]{1, 2, 3, 4});
        for (int i : exchange) {
            System.out.println(i);
        }
    }

    class Solution {
        /**
         * 双指针，一个从头开始遍历，一个从尾开始遍历
         *
         * @param nums
         * @return
         */
        public int[] exchange(int[] nums) {
            int low = 0;
            int high = nums.length - 1;

            while (low < high) {
                while (low < high && (nums[low] & (2 - 1)) == 1)
                    low++;
                while (high > low && (nums[high] & (2 - 1)) == 0)
                    high--;

                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
            }
            return nums;
        }
    }
}
