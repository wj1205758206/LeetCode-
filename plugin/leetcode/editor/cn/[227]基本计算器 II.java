
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //字符串形式的正整数
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            //遇到左括号开始递归计算 calculate( 计算()里面的值 )
            if (c == '(') {
                num = calculate(s);
            }
            //如果不是数字，就是遇到了下一个符号,之前的数字和符号就要存进栈中
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        int preMulti = stack.peek();
                        stack.pop();
                        stack.push(preMulti * num);
                        break;
                    case '/':
                        int preDiv = stack.peek();
                        stack.pop();
                        stack.push(preDiv / num);
                        break;
                }
                // 更新符号为当前符号，数字清零
                sign = c;
                num = 0;
            }
            //遇到右括号返回递归结果
            if (c == ')') {
                break;
            }
        }
        int result = 0;
        while (!stack.isEmpty()) {
            result += stack.peek();
            stack.pop();
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
