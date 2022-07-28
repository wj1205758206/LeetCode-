
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    List<String> wordDict;
    // 记录是否找到一个合法的答案
    boolean found = false;
    // 记录回溯算法的路径
    LinkedList<String> track = new LinkedList<>();

    // 主函数
    public boolean wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        // 执行回溯算法穷举所有可能的组合
        backtrack(s, 0);
        return found;
    }

    // 回溯算法框架
    void backtrack(String s, int i) {
        // base case
        if (found) {
            // 如果已经找到答案，就不要再递归搜索了
            return;
        }
        if (i == s.length()) {
            // 整个 s 都被匹配完成，找到一个合法答案
            found = true;
            return;
        }

        // 回溯算法框架
        for (String word : wordDict) {
            // 看看哪个单词能够匹配 s[i..] 的前缀
            int len = word.length();
            if (i + len <= s.length()
                    && s.substring(i, i + len).equals(word)) {
                // 找到一个单词匹配 s[i..i+len)
                // 做选择
                track.addLast(word);
                // 进入回溯树的下一层，继续匹配 s[i+len..]
                backtrack(s, i + len);
                // 撤销选择
                track.removeLast();
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
