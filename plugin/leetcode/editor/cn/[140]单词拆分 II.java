
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> result = new ArrayList<>();
    List<String> track = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        backtrack(s, 0, wordDict);
        return result;
    }

    public void backtrack(String s, int i, List<String> wordList) {
        if (i == s.length()) {
            result.add(String.join(" ", track));
            return;
        }

        for (String word : wordList) {
            int len = word.length();
            if (i + len <= s.length() && s.substring(i, i + len).equals(word)) {
                track.add(word);
                backtrack(s, i + len, wordList);
                track.remove(track.size() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
