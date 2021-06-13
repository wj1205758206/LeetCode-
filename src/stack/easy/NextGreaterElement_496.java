package stack.easy;

import java.util.*;

/**
 * 查找指定数组中下一个更大的元素
 */
public class NextGreaterElement_496 {
    public static void main(String[] args) {
        int[] nums1 = {1,3,5,2,4};
        int[] nums2 = {6,5,4,3,2,1,7};
        Solution solution = new Solution();
        int[] nextGreaterElement = solution.nextGreaterElement2(nums1, nums2);
        for (int i = 0; i < nextGreaterElement.length; i++) {
            System.out.print(nextGreaterElement[i]);
        }
    }

    static class Solution {
        /**
         * 方法一：暴力求解
         * 双重循环遍历，遍历找到第一个比当前元素大的值，保存这个值
         * @param nums1 是nums2的子集，第一层遍历
         * @param nums2 第二层遍历，从中找到比当前元素大的下一个值
         * @return  返回结果数组
         */
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int[] next = new int[nums1.length];

            /*判断是否有比当前元素更大的值*/
            boolean find = false;

            for (int i = 0; i < nums1.length; i++) {

                /*从nums2中定位nums1中的元素在nums2中的索引位置*/
                int j = 0;
                while (nums2[j] != nums1[i])
                    j++;

                /*从j往后开始遍历是否有比当前值更大的元素*/
                for (; j < nums2.length; j++) {
                    if (nums2[j] > nums1[i]) {
                        next[i] = nums2[j];
                        find = true;
                        break;
                    }
                }

                /*如果没有从nums2中找到更大的元素，则置为-1*/
                if (!find) {
                    next[i] = -1;
                }

                /*每次查找都要重置为false*/
                find = false;
            }
            return next;
        }

        /**
         * 方法二：单调栈方法
         * @param nums1 nums2的子集
         * @param nums2 从nums2中查询下一个更大的元素
         * @return  返回结果数组
         */
        public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
            int[] next = new int[nums1.length];
            Stack<Integer> stack = new Stack<>();
            Map<Integer,Integer> map = new HashMap<>();

            /*for循环从后往前扫描元素
            * 倒着入栈也就是正这出栈，也就相当于找第一个比当前元素大的值*/
            for (int i = nums2.length - 1; i >= 0; i--) {
                /*当栈不为空，且栈里面的元素小于当前元素时，就会弹出栈里所有比当前元素小的值
                * 即排除掉第一个更大元素大之前所有的"小"元素
                * 这样，栈顶始终是比当前元素第一个更大的数*/
                while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                    stack.pop();
                }

                /*保存每个元素与更大元素之间的映射关系，方便之后从子集找到映射关系*/
                map.put(nums2[i],stack.isEmpty() ? -1 : stack.peek());

                /*每个元素都会入栈，在排除所有比当前元素更小的值之后，并且保存当前元素与更大元素之间的映射关系之后，才入栈*/
                stack.push(nums2[i]);
            }

            /*遍历子集，根据map映射关系查询出更大元素*/
            for (int i = 0; i < nums1.length; i++) {
                next[i] = map.get(nums1[i]);
            }
            return next;
        }
    }
}
