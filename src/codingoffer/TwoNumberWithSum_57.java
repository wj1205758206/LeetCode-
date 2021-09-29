package codingoffer;

/**
 * 两数和(双指针)
 */
public class TwoNumberWithSum_57 {
    public static void main(String[] args) {
        Solution solution = new TwoNumberWithSum_57().new Solution();
        int[] res = solution.twoSum(new int[]{45, 46, 67, 73, 74, 74, 77, 83, 89, 98}, 147);
        for (int num : res) {
            System.out.println(num);
        }
    }

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            if (nums.length == 0) return new int[0];
            int left = 0, right = nums.length - 1;
            int[] res = new int[2];
            while (nums[right] > target) right--;
            while (left < right) {
                if (nums[left] + nums[right] > target) {
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    res[0] = nums[left];
                    res[1] = nums[right];
                    break;
                }
            }
            return res;
        }
    }
}
