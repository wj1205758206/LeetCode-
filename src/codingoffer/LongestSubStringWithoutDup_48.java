package codingoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长不含重复字符的子字符串(哈希表+双指针)
 */
public class LongestSubStringWithoutDup_48 {
    public static void main(String[] args) {
        Solution solution = new LongestSubStringWithoutDup_48().new Solution();
        System.out.println(solution.lengthOfLongestSubstring2("abcabcbb"));
    }

    class Solution {
        /**
         * 哈希表记录是否有重复，直接双重循环遍历
         *
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring(String s) {
            if (s.isEmpty() || s.length() == 0) return 0;
            int result = 0;
            for (int i = 0; i < s.length(); i++) {
                int max = 0;
                Map<Integer, Character> map = new HashMap<>();
                for (int j = i; j < s.length(); j++) {
                    if (!map.containsValue(s.charAt(j))) {
                        map.put(j, s.charAt(j));
                        max++;
                    } else {
                        break;
                    }
                }
                result = Math.max(result, max);
            }
            return result;
        }

        /**
         * 双指针，滑动窗口
         *
         * @param s
         * @return
         */
        public int lengthOfLongestSubstring2(String s) {
            if (s.isEmpty() || s.length() == 0) return 0;

            int res = 0;
            int i = -1;
            Map<Character, Integer> map = new HashMap<>();

            for (int j = 0; j < s.length(); j++) {
                if (map.containsKey(s.charAt(j))) {
                    //i始终指向重复的最大下标，这样才能保证 i ~ j是不重复的
                    i = Math.max(i, map.get(s.charAt(j)));
                }
                map.put(s.charAt(j), j);
                res = Math.max(res, j - i);
            }
            return res;
        }
    }
}
