
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        int longest = 0;
        //始终保持栈底元素为当前已经遍历过的元素中[最后一个没有被匹配的右括号的下标]
        Stack<Integer> stack = new Stack<>();
        //如果一开始栈为空，第一个字符为左括号的时候我们会将其放入栈中，这样就不满足提及的「最后一个没有被匹配的右括号的下标」，
        //为了保持统一，我们在一开始的时候往栈中放入一个值为 −1 的元素。
        stack.push(-1);

        for (int i = 0; i < s.length(); i++) {
            //对于遇到的每个 ( ，我们将它的 下标 放入栈中
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                //对于遇到的每个 ) ，我们先弹出栈顶元素表示匹配了当前右括号
                stack.pop();
                //如果栈为空，说明当前的右括号为没有被匹配的右括号，
                // 我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    //如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
                    longest = Math.max(longest, i - stack.peek());
                }
            }
        }
        return longest;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
