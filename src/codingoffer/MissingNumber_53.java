package codingoffer;

/**
 * 丢失的数字(二分查找)
 */
public class MissingNumber_53 {
    public static void main(String[] args) {
        Solution solution = new MissingNumber_53().new Solution();
        System.out.println(solution.missingNumber2(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}));
    }

    class Solution {
        public int missingNumber(int[] nums) {
            int t = -1;
            int i;
            for (i = 0; i < nums.length; i++) {
                if (nums[i] != i) {//找出第一个元素值和下标不一样的那个元素
                    t = i;
                    break;
                }
            }
            //特殊情况，肯有可能数组元素值和坐标都一一对应，但是丢失的是最后一个元素n，下标是0-n-1
            if (i == nums.length) t = nums.length;
            return t;
        }

        public int missingNumber2(int[] nums) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] != mid) {
                    if (mid == 0 || nums[mid - 1] == mid - 1)
                        return mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            if (left == nums.length) return nums.length;
            return -1;
        }
    }
}
