package dp.medium;

import java.util.Arrays;

/**
 * 两个字符串的最小ASCII删除和
 */
public class MinASCIIDeleteSumForTwoStrings_712 {
    public static void main(String[] args) {
        Solution solution = new MinASCIIDeleteSumForTwoStrings_712().new Solution();
        System.out.println(solution.minimumDeleteSum("delete", "leet"));
    }

    class Solution {
        /**
         * 其实这道题也是相当于求解最大公共子序列的问题，只不过需要进行一些改动
         *
         * @param s1
         * @param s2
         * @return
         */
        public int minimumDeleteSum(String s1, String s2) {
            int[][] memory = new int[s1.length()][s2.length()];
            for (int[] row : memory) {
                Arrays.fill(row, -1);
            }

            return dp(s1, 0, s2, 0, memory);
        }

        private int dp(String s1, int i, String s2, int j, int[][] memory) {
            int result = 0;

            /*基准条件
             * 如果这两个字符串有其中任何一个遍历完了
             * 那么另一个字符串就要把剩下的字符全部删除，需要累加剩余字符的ASCII码，并返回*/
            if (i == s1.length()) {
                for (; j < s2.length(); j++) {
                    result += s2.charAt(j);
                }
                return result;
            }
            if (j == s2.length()) {
                for (; i < s1.length(); i++) {
                    result += s1.charAt(i);
                }
                return result;
            }

            if (memory[i][j] != -1)
                return memory[i][j];

            if (s1.charAt(i) == s2.charAt(j)) {
                //相等不用删除，也就不用计算ASCII码
                memory[i][j] = dp(s1, i + 1, s2, j + 1, memory);
            } else {
                //不相同时，需要选择删除s1的元素还是删除s2的元素，并把字符ASCII递归累加，然后取最小值
                memory[i][j] = Math.min(
                        s1.charAt(i) + dp(s1, i + 1, s2, j, memory),
                        s2.charAt(j) + dp(s1, i, s2, j + 1, memory)
                );
            }
            return memory[i][j];
        }
    }
}
