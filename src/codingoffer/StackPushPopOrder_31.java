package codingoffer;

import java.util.Stack;

/**
 * 判断栈的压入弹出序列是否合法
 */
public class StackPushPopOrder_31 {
    public static void main(String[] args) {
        Solution solution = new StackPushPopOrder_31().new Solution();
        System.out.println(solution.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }

    class Solution {
        /**
         * 使用一个辅助栈，模拟压栈和出栈的过程，到最后如果栈为空，说明弹出序列是合法的
         *
         * @param pushed
         * @param popped
         * @return
         */
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            int pushLen = pushed.length;
            int popLen = popped.length;
            int i = 0, j = 0;   //记录压栈数组和出栈数组当前的遍历位置
            Stack<Integer> stack = new Stack<>();

            while (i < pushLen && j < popLen) {
                //如果入栈元素和出栈元素不相等，则直接把元素压栈，继续比较下一个入栈元素是否相等
                if (pushed[i] != popped[j]) {
                    stack.push(pushed[i]);
                    i++;
                } else {
                    //如果相当说明将这个元素压栈，然后立即弹出，当前元素顺序满足，继续比较下一对元素
                    i++;
                    j++;
                    //下一对元素很有可能不相等，但是有可能当前栈顶元素与之相等，就不断循环判断已入栈的元素是否满足接下来的弹出顺序
                    while (!stack.isEmpty() && stack.peek() == popped[j]) {
                        stack.pop();
                        j++;
                    }
                }
            }
            //有可能入栈操作已完成，但是出栈序列还没有完成，此时栈内还有元素，需要不断判断比较栈顶元素和接下来的出栈顺序
            if (j <= popLen) {
                while (!stack.isEmpty() && stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                }
            }
            //栈为空，说明弹出顺序合法
            return stack.isEmpty();
        }
    }
}
