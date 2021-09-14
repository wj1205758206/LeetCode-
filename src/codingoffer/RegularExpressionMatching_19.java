package codingoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 正则表达式匹配
 */
public class RegularExpressionMatching_19 {
    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching_19().new Solution();
        System.out.println(solution.isMatch("ab", ".*c"));
    }

    class Solution {
        Map<String, Boolean> memory;

        public boolean isMatch(String s, String p) {
            memory = new HashMap<>();

            return dp(s, 0, p, 0);
        }

        private boolean dp(String s, int i, String p, int j) {
            if (j == p.length())
                return i == s.length();
            if (i == s.length()) {
                if ((p.length() - j) % 2 == 1)
                    return false;
                for (; j < p.length() - 1; j += 2) {
                    if (p.charAt(j + 1) != '*')
                        return false;
                }
                return true;
            }
            String key = i + "," + j;
            if (memory.containsKey(key))
                return memory.get(key);

            boolean result = false;

            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                    result = dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
                } else {
                    result = dp(s, i + 1, p, j + 1);
                }
            } else {
                if (j < p.length() - 1 && p.charAt(j + 1) == '*') {
                    result = dp(s, i, p, j + 2);
                } else {
                    result = false;
                }
            }

            memory.put(key, result);
            return memory.get(key);
        }
    }
}
