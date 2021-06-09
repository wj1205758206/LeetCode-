package array.easy;

import java.util.*;

/**
 * 在无序的数组中查找是否存在两数之和等于目标值
 */
public class TwoSum_1 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        Solution solution = new Solution();
        int[] index = solution.twoSum(nums, 9);
        System.out.println("[" + index[0] + "," + index[1] + "]");

    }

    static class Solution {
        /**
         * 方法一：暴力求解，两个for循环挨个相加进行比较，时间复杂度 O(n²)，空间复杂度 O(1)
         * @param nums  传入的无序数组
         * @param target    目标值
         * @return
         */
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i,j};
                    }
                }
            }
            return new int[]{-1,-1};
        }

        /**
         * 方法二：
         * 使用哈希集合存放无序数组每个元素及对应的索引坐标，
         * 只需一个for循环遍历一个加数，另一个加数从哈希表中查询
         * 时间复杂度为 O(n),空间复杂度为 O(n)
         *
         * @param nums
         * @param target
         * @return
         */
        public int[] twoSum2(int[] nums, int target) {
            Map<Integer,Integer> index = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                index.put(nums[i],i);
            }

            for (int i = 0; i < nums.length; i++) {
                int other = target - nums[i];
                if (index.containsKey(other) && index.get(other) != i) {
                    return new int[]{i,index.get(other)};
                }
            }
            return new int[]{-1,-1};
        }
    }
}
