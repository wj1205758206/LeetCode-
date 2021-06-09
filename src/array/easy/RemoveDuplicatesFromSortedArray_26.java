package array.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 原地删除排序数组中的重复项
 */
public class RemoveDuplicatesFromSortedArray_26 {
    public static void main(String[] args) {
        int[] nums = {};
        Solution solution = new Solution();
        int count = solution.removeDuplicates(nums);
        System.out.println(count);
        for (int i = 0; i < count; i++) {
            System.out.print(nums[i]);
        }
    }

    static class Solution {
        /**
         * 方法一：循环遍历，挨个比较然后交换
         * @param nums  传入的排序数组
         * @return  返回去重后的元素个数
         */
        public int removeDuplicates(int[] nums) {
            if (nums.length == 0)
                return 0;
            int i, j;
            i = j = 0;
            while (j < nums.length) {
                /*定位与当前i位置不相等的元素，j指向第一个与i位置不相等的元素的索引
                * 将第一个不相等值放到i位置的下一个位置*/
                if (nums[i] == nums[j]) {
                    j++;
                }else {
                    nums[++i] = nums[j];
                }
            }
            return i + 1;
        }

        /**
         * 方法二：使用set集合去重，然后将set去重后的元素重新赋值给原数组，并排序
         * @param nums  传入的有序数组
         * @return  返回去重后的数组的元素个数
         */
        public int removeDuplicates2(int[] nums) {
            if (nums.length == 0)
                return 0;
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            Iterator<Integer> iterator = set.iterator();
            int i = 0;
            while (iterator.hasNext()){
                nums[i++] = iterator.next();
            }
            Arrays.sort(nums,0,set.size());
            return set.size();
        }
    }
}
