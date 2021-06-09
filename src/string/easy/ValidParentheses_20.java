package string.easy;

import java.util.Stack;

public class ValidParentheses_20 {
    public static void main(String[] args) {
        System.out.println(isValid("()"));

    }

/*    public static boolean isValid(String s){
        Map<Character,Integer> map = new HashMap<>();
        map.put('(',0);
        map.put(')',0);
        map.put('[',1);
        map.put(']',1);
        map.put('{',2);
        map.put('}',2);

        if (s.isEmpty())
            return true;
        int i = 0;
        int j = s.length() - 1;
        int flag = 1;
        while (i < j){
            if ((map.get(s.charAt(i)) == map.get(s.charAt(j))) && (s.charAt(i) != s.charAt(j))){
                i++;
                j--;
                flag = 1;
            }else {
                flag = 0;
                break;
            }
        }
        if (flag == 0){
            return false;
        }

        return true;
    }*/

    public static boolean isValid(String s) {
        if (s == "")
            return true;
        if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}')
            return false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() && (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}'))
                return false;
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if (!stack.isEmpty()) {
                if (s.charAt(i) == ')') {
                    if (stack.peek() == '(')
                        stack.pop();
                    else
                        return false;
                } else if (s.charAt(i) == ']') {
                    if (stack.peek() == '[')
                        stack.pop();
                    else
                        return false;
                } else if (s.charAt(i) == '}') {
                    if (stack.peek() == '{')
                        stack.pop();
                    else
                        return false;
                }
            }

        }
        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }
}
