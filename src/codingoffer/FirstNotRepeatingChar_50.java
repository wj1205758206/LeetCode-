package codingoffer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 第一个只出现一次的字符
 */
public class FirstNotRepeatingChar_50 {
    public static void main(String[] args) {
        Solution solution = new FirstNotRepeatingChar_50().new Solution();
        System.out.println(solution.firstUniqChar("abaccdeff"));
    }

    class Solution {
        /**
         * 哈希表记录出现次数
         *
         * @param s
         * @return
         */
        public char firstUniqChar(String s) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    Integer times = map.get(s.charAt(i));
                    map.put(s.charAt(i), times + 1);
                } else {
                    map.put(s.charAt(i), 1);
                }
            }
            for (int i = 0; i < s.length(); i++) {
                if (map.get(s.charAt(i)) == 1)
                    return s.charAt(i);
            }
            return ' ';
        }

        /**
         * 有序哈希表
         *
         * @param s
         * @return
         */
        public char firstUniqChar2(String s) {
            Map<Character, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    Integer times = map.get(s.charAt(i));
                    map.put(s.charAt(i), times + 1);
                } else {
                    map.put(s.charAt(i), 1);
                }
            }
            for (Character c : map.keySet()) {
                if (map.get(c) == 1)
                    return c;
            }
            return ' ';
        }
    }
}
