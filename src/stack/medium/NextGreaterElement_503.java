package stack.medium;

import java.util.Arrays;
import java.util.Stack;

/**
 * 循环数组查找下一个更大的数
 */
public class NextGreaterElement_503 {
    public static void main(String[] args) {
        int[] next = {1,2,3,4,3};

        Solution solution = new Solution();
        int[] nextGreaterElements = solution.nextGreaterElements(next);

        for (int element : nextGreaterElements) {
            System.out.print(element);
        }


    }
    static class Solution {
        /**
         * 方法一：将数组长度翻倍构造一个新的数组，然后使用单调栈操作翻倍后的新数组
         * @param nums  在指定的nums中查询下一个比当前更大的数
         * @return  返回更大数的结果数组
         */
        public int[] nextGreaterElements(int[] nums) {

            /*将传入的数组翻倍，相当于多复制一个一模一样的数组，合并两个数组到新的数组，实现循环的效果*/
            int[] doubleNums = Arrays.copyOf(nums, nums.length * 2);
            System.arraycopy(nums,0,doubleNums,nums.length,nums.length);

            /*操作新的翻倍的数组，next保存翻倍数组的查询结果*/
            int[] next = new int[doubleNums.length];

            Stack<Integer> stack = new Stack<>();

            /*单调栈倒着入栈翻倍数组的元素，正这出栈，相当于查询第一个比当前元素更大的值*/
            for (int i = doubleNums.length - 1; i >= 0; i--) {
                /*比当前元素小的栈内元素都被弹出，这样栈顶就是第一个比当前元素更大的那个值*/
                while (!stack.isEmpty() && stack.peek() <= doubleNums[i]) {
                    stack.pop();
                }

                /*获取栈顶元素的值，而不是弹出，保存在next中，即这个值就是比当前元素第一个更大的值*/
                next[i] = stack.isEmpty() ? -1 : stack.peek();

                /*将当前元素入栈，用于后续的比较*/
                stack.push(doubleNums[i]);
            }

            /*因为操作的是新的翻倍后的数组，所以返回的结果数组应该是next的前一半即可*/
            int[] result = Arrays.copyOf(next, nums.length);
            return result;
        }

        /**
         * 方法二：使用 求模运算 来模拟循环数组的效果
         * @param nums  传入的查询下一个更大值的数组
         * @return  返回更大值结果的数组
         */
        public int[] nextGreaterElements2(int[] nums) {
            int[] next = new int[nums.length];
            Stack<Integer> stack = new Stack<>();

            /*实现循环数组的效果，可以使用 求模运算 来模拟循环的效果
            * 将传入的数组长度 * 2，假设构造了一个长度翻倍的新数组，这时数组的索引就必须进行求模运算
             * 然后用单调栈的方法进行计算下一个更大的值*/
            for (int i = nums.length * 2 - 1; i >= 0; i--) {
                while (!stack.isEmpty() && stack.peek() <= nums[i % nums.length]) {
                    stack.pop();
                }

                next[i % nums.length] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(nums[i % nums.length]);
            }
            return next;
        }
    }
}
