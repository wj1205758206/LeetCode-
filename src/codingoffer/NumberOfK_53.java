package codingoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 在排序数组中查找数字 I(二分查找左右边界)
 */
public class NumberOfK_53 {
    public static void main(String[] args) {
        Solution solution = new NumberOfK_53().new Solution();
        System.out.println(solution.search3(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }

    class Solution {
        public int search(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    int times = map.get(nums[i]);
                    map.put(nums[i], times + 1);
                } else {
                    map.put(nums[i], 1);
                }
            }
            return map.get(target) == null ? 0 : map.get(target);
        }

        public int search2(int[] nums, int target) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) res++;
            }
            return res;
        }

        /**
         * 两次二分查找，找左右边界
         *
         * @param nums
         * @param target
         * @return
         */
        public int search3(int[] nums, int target) {
            if (nums.length == 0) return 0;

            return binarySearch(nums, target) - binarySearch(nums, target - 1);
        }

        private int binarySearch(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (nums[mid] <= target)    //一定要带等于号，这样才能找到target的右边界！
                    left = mid + 1;
                else right = mid - 1;
            }
            return left;
        }
    }
}
