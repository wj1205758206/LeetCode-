package dp.hard;

import java.util.Arrays;

/**
 * 计算最小的编辑距离
 */
public class EditDistance_72 {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";

        Solution solution = new EditDistance_72().new Solution();
        System.out.println(solution.minDistance3(word1, word2));
    }

    class Solution {
        /**
         * 方法一：直接暴力递归
         *
         * @param word1
         * @param word2
         * @return
         */
        public int minDistance(String word1, String word2) {
            return dp(word1, word2, word1.length() - 1, word2.length() - 1);
        }

        private int dp(String word1, String word2, int i, int j) {

            /*基准条件
             *i和j从两个字符串末尾从头部遍历
             * 如果有其中一个遍历结束，即索引为-1了，就直接返回另一个字符串的长度
             * 如果word2先遍历完，说明word1从0-i索引，即i+1个元素就不需要的，直接截断，说明还需要操作i+1次删除操作
             * 如果word1先遍历完，说明word2从0-j索引，即j+1个元素还需要插入到word1头部，说明还需要操作j+1次插入操作*/
            if (i == -1) return j + 1;
            if (j == -1) return i + 1;

            /*如果当前比较的两个元素相同，则不需操作，直接跳过，进入下一次比较*/
            if (word1.charAt(i) == word2.charAt(j))
                return dp(word1, word2, i - 1, j - 1);

            /*三选一，做出选择，返回最小值，即操作次数最少的值*/
            return retMin(
                    dp(word1, word2, i, j - 1) + 1,         //选择插入,操作数加一
                    dp(word1, word2, i - 1, j) + 1,         //选择删除，操作数加一
                    dp(word1, word2, i - 1, j - 1) + 1   //选择替换。操作数加一
            );
        }

        private int retMin(int i, int j, int k) {
            return Math.min(Math.min(i, j), k);
        }

        /**
         * 方法二：使用备忘录进行递归，减少重叠子问题的计算
         *
         * @param word1
         * @param word2
         * @return
         */
        public int minDistance2(String word1, String word2) {
            int[][] memory = new int[word1.length()][word2.length()];
            for (int[] mem : memory) {
                Arrays.fill(mem, -1);
            }
            return dp2(word1, word2, word1.length() - 1, word2.length() - 1, memory);
        }

        private int dp2(String word1, String word2, int i, int j, int[][] memory) {
            if (i == -1) return j + 1;
            if (j == -1) return i + 1;

            if (memory[i][j] != -1)
                return memory[i][j];


            if (word1.charAt(i) == word2.charAt(j)) {
                memory[i][j] = dp2(word1, word2, i - 1, j - 1, memory);
                return memory[i][j];
            }


            /*对于子问题 dp(i-1, j-1)，如何通过原问题 dp(i, j) 得到呢？
             *有不止一条路径，比如 dp(i, j) 选择替换-> dp(i-1, j-1) 和 dp(i, j) 选择插入-> dp(i, j-1) 再选择替换-> dp(i-1, j-1)。
             * 一旦发现一条重复路径，就说明存在巨量重复路径，也就是重叠子问题。*/
            memory[i][j] = retMin(
                    dp2(word1, word2, i, j - 1, memory) + 1,         //选择插入,操作数加一
                    dp2(word1, word2, i - 1, j, memory) + 1,         //选择删除，操作数加一
                    dp2(word1, word2, i - 1, j - 1, memory) + 1   //选择替换。操作数加一
            );

            return memory[i][j];
        }

        /**
         * 方法三：动态规划，使用DP表，自底向上的迭代计算
         *
         * @param word1
         * @param word2
         * @return
         */
        public int minDistance3(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            int[][] dp = new int[m + 1][n + 1];

            /*基准条件
             * 索引从1开始保存着字符串的第一个元素
             * 索引0作为空字符串，边界条件，相当于递归中索引为-1的情况*/
            for (int i = 1; i <= m; i++) {
                dp[i][0] = i;
            }
            for (int j = 1; j <= n; j++) {
                dp[0][j] = j;
            }

            /*双重循环，迭代计算，填满DP表
             * dp[i][j] 存储 word1[0..i] 和 word2[0..j] 的最小编辑距离*/
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];//比较的两个元素相同，替换或者跳过，自底向上，计算下一轮迭代
                    } else {
                        dp[i][j] = retMin(
                                dp[i][j - 1] + 1,       //选择插入，则从上一轮dp[i][j - 1]插入迭代计算出的结果加一
                                dp[i - 1][j] + 1,       //选择删除，则从上一轮p[i - 1][j]删除迭代计算出的结果加一
                                dp[i - 1][j - 1] + 1    //选择替换，则从上一轮dp[i - 1][j - 1]替换迭代计算出的结果加一
                        );
                    }
                }
            }
            // 储存着整个 word1 和 word2 的最小编辑距离
            return dp[m][n];
        }
    }
}
