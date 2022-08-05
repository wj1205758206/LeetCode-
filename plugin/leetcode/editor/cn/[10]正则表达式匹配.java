
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap<String, Boolean> memory = new HashMap<>();

    public boolean isMatch(String s, String p) {
        return dp(s, 0, p, 0);
    }

    public boolean dp(String s, int i, String p, int j) {
        int m = s.length();
        int n = p.length();

        if (j == n) {
            return i == m;
        }
        if (i == m) {
            if ((n - j) % 2 == 1) {
                return false;
            }
            for (; j + 1 < n; j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }

        String key = i + "," + j;
        if (memory.containsKey(key)) {
            return memory.get(key);
        }

        boolean result = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                result = dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            } else {
                result = dp(s, i + 1, p, j + 1);
            }
        } else {
            if (j < n - 1 && p.charAt(j + 1) == '*') {
                result = dp(s, i, p, j + 2);
            } else {
                result = false;
            }
        }
        memory.put(key, result);
        return memory.get(key);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
