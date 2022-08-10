
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sarr = new int[26];
        int[] tarr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sarr[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            tarr[t.charAt(i) - 'a'] += 1;
        }

        for (int i = 0; i < sarr.length; i++) {
            if (sarr[i] != tarr[i]) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
