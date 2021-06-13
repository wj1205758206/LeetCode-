package stack.medium;


import java.util.Stack;

/**
 * 每日温度，查找比当前温度更高的那一天，并返回距离当日的天数
 */
public class DailyTemperatures_739 {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        Solution solution = new Solution();
        int[] dailyTemperatures = solution.dailyTemperatures(temperatures);
        for (int temperature : dailyTemperatures) {
            System.out.print(temperature + " ");
        }

    }
    static class Solution {
        /**
         * 使用单调栈方法
         * @param temperatures  传入的每日温度数组
         * @return  返回距离温度更高的那天距离当前的天数
         */
        public int[] dailyTemperatures(int[] temperatures) {
            int[] next = new int[temperatures.length];

            Stack<Integer> stack = new Stack<>();

            /*倒着入栈，正这出栈，就相当于查找第一个比当前温度更高的那一天
            * 相比于查找下一个更大的数，这道题目是返回距离更大数的间距是多少，即过多少天，才到达更高温度的那一天*/
            for (int i = temperatures.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                    stack.pop();
                }

                /*栈顶始终是比当前温度第一个且更高温度的那天的索引，减去当前索引i，即为距离*/
                next[i] = stack.isEmpty() ? 0 : (stack.peek() - i);

                /*入栈的不是元素本身，而是元素的索引*/
                stack.push(i);
            }
            return next;
        }
    }
}
