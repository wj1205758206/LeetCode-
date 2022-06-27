
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        //dp表定义：dp[i][j]表示长度为i的word1，编辑成长度为j的word2，最少的操作次数
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(
                            dp[i][j - 1] + 1,//w1插入操作，w2前移继续匹配
                            dp[i - 1][j] + 1, //w1删除操作，w2不动，w1前移继续匹配
                            dp[i - 1][j - 1] + 1 //w1替换操作，w1和w2都前移继续匹配
                    );
                }
            }
        }
        return dp[m][n];
    }

    public int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
