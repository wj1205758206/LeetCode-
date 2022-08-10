
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    HashMap<Character, List<Integer>> charToIndex = new HashMap<>();
    HashMap<String, Integer> mem = new HashMap<>();

    public int findRotateSteps(String ring, String key) {
        int m = ring.length();
        int n = key.length();
        for (int i = 0; i < ring.length(); i++) {
            char c = ring.charAt(i);
            if (!charToIndex.containsKey(c)) {
                charToIndex.put(c, new ArrayList<>());
            }
            charToIndex.get(c).add(i);
        }

        return dp(ring, 0, key, 0);
    }

    public int dp(String ring, int i, String key, int j) {
        if (j == key.length()) {
            return 0;
        }
        String memKey = i + "," + j;
        if (mem.containsKey(memKey)) {
            return mem.get(memKey);
        }

        int res = Integer.MAX_VALUE;
        int n = ring.length();
        for (int index : charToIndex.get(key.charAt(j))) {
            int delta = Math.abs(index - i);
            delta = Math.min(delta, n - delta);
            int subProblem = dp(ring, index, key, j + 1);
            res = Math.min(res, delta + subProblem + 1);
        }
        mem.put(memKey, res);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
