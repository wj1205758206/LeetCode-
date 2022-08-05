
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int maxLen = 0;
        boolean extraOdd = false;
        for (int count : map.values()) {
            if (count % 2 == 0) {
                maxLen += count;
            } else {
                maxLen += count - 1;
                extraOdd = true;
            }
        }
        return extraOdd ? maxLen + 1 : maxLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
