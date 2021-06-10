package array.easy;

/**
 * 移动数组中所有的 0 ，并把 0 放在数组最后面
 */
public class MoveZeroes_283 {
    public static void main(String[] args) {
        int[] nums = {1,5,0,2,3,0,6,0};
        Solution solution = new Solution();
        solution.moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num);
        }

    }
    static class Solution {
        /**
         * 使用快慢双指针，相当于去除数组中指定元素，只不过指定的元素是 0 ，然后把剩下的元素都置 0 即可
         * @param nums
         */
        public void moveZeroes(int[] nums) {
            int slow, fast;
            slow = fast = 0;
            while (fast < nums.length) {
                if (nums[fast] != 0) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            /*剩余元素置为0*/
            for (int i = slow; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }
}
