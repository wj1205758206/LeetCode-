package dp.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 正则表达式匹配
 */
public class RegularExpressionMatching_10 {
    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching_10().new Solution();
        System.out.println(solution.isMatch("aab", "c*a*b"));
    }

    class Solution {
        Map<String, Boolean> memory;

        public boolean isMatch(String s, String p) {
            memory = new HashMap<>();

            /*dp函数定义
             * s[i..]是否能匹配p[j..]*/
            return dp(s, 0, p, 0);
        }

        private boolean dp(String s, int i, String p, int j) {
            int m = s.length();
            int n = p.length();

            /*如果说p正则已经完全匹配，只需看s字符串是否全部匹配成功即可*/
            if (j == n)
                return i == m;

            /*如果s字符串全部匹配成功，不能光看p正则是否全部匹配
             * 应该看p剩下的是否能够匹配空串，也就是说剩下的是否可以全部匹配0次*/
            if (i == m) {
                /*匹配空串，必定字符和*成对出现*/
                if ((n - j) % 2 == 1)
                    return false;
                /*同时需要保证是以x*y*z*的形式成对出现的*/
                for (; j + 1 < n; j += 2) {
                    if (p.charAt(j + 1) != '*')
                        return false;
                }
                return true;
            }

            /*备忘录，以坐标（i，j）作为状态*/
            String key = String.valueOf(i + "," + j);
            if (memory.containsKey(key))
                return memory.get(key);

            boolean result = false;

            if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                /*如果当前两个字符匹配成功，则需要看下一个字符是否是【*】
                 * 我们可以选择匹配0次，也就是跳过（j+2），或者选择匹配多次，j不变，i向前一步
                 * */
                if (j < n - 1 && p.charAt(j + 1) == '*') {
                    result = dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
                } else {
                    /*如果当前两个字符匹配成功，下一个字符不是【*】，那么直接常规匹配两个字符即可，继续匹配下一对字符*/
                    result = dp(s, i + 1, p, j + 1);
                }
            } else {
                /*如果说当前两个字符不相同，并且也不是【.】
                 * 那么需要判断下一个字符是否是【*】，如果是，我们可以选择匹配0次，跳过，继续判断是否可以和后面的匹配成功*/
                if (j < n - 1 && p.charAt(j + 1) == '*') {
                    result = dp(s, i, p, j + 2);
                } else {
                    /*如果两个字符既不相等，下一个也不是【*】无法跳过匹配后面的
                     * 那么说明s和p并不能成功匹配，直接返回false*/
                    result = false;
                }
            }

            memory.put(key, result);

            return memory.get(key);
        }
    }
}
