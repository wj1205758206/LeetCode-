package codingoffer;

import java.util.*;

/**
 * 数组中重复的数字
 */
public class DuplicateInArray_03 {
    public static void main(String[] args) {

    }

    class Solution {
        public int findRepeatNumber(int[] nums) {
            Set<Integer> map = new HashSet<>();

            for (int i = 0; i < nums.length; i++) {
                if (map.contains(nums[i]))
                    return nums[i];
                map.add(nums[i]);
            }

            return -1;
        }

        public int findRepeatNumber2(int[] nums) {
            Arrays.sort(nums);

            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == nums[i + 1])
                    return nums[i];
            }
            return -1;
        }

        public int findRepeatNumber3(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                //不断重复交换数组下标和元素，使其一一对应
                while (i != nums[i]) {
                    //如果当前元素的值，和以元素值为下标的那个位置的元素值相等，说明出现重复元素
                    if (nums[i] == nums[nums[i]])
                        return nums[i];
                    int temp = nums[nums[i]];
                    nums[i] = temp;
                    nums[nums[i]] = nums[i];
                }
            }
            return -1;
        }
    }
}
