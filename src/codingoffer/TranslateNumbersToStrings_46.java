package codingoffer;

/**
 * 把数字翻译成字符串
 */
public class TranslateNumbersToStrings_46 {
    public static void main(String[] args) {
        Solution solution = new TranslateNumbersToStrings_46().new Solution();
        System.out.println(solution.translateNum2(25));
    }

    class Solution {
        int result = 0;

        /**
         * 回溯算法
         *
         * @param num
         * @return
         */
        public int translateNum(int num) {
            String s = String.valueOf(num);
            StringBuilder track = new StringBuilder();

            backtrack(s, 0, s.length(), track);

            return result;
        }

        private void backtrack(String s, int start, int length, StringBuilder track) {
            if (start >= length) {
                result++;
                return;
            }
            //每次可以选择1个或者2个字符
            for (int i = 1; i <= 2; i++) {
                if (start + i <= length) {
                    String temp = s.substring(start, start + i);
                    if (!isValid(temp))
                        continue;
                    track.append(temp);
                    backtrack(s, start + i, length, track);
                    track.delete(track.length() - temp.length(), track.length() - 1);

                }
            }

           /* track.append(start);
            backtrack(s, start + 1, length, track);
            track.deleteCharAt(track.length() - 1);

            if (start + 2 < length) {
                String temp = s.substring(start, start + 2);
                if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) {
                    track.append(temp);
                    backtrack(s, start + 2, length, track);
                    track.delete(track.length() - 2, track.length() - 1);
                }
            }*/
        }

        private boolean isValid(String s) {
            if (s.length() > 1)
                return s.compareTo("10") >= 0 && s.compareTo("25") <= 0;
            return true;
        }

        /**
         * 动态规划，dp表迭代计算
         *
         * @param num
         * @return
         */
        public int translateNum2(int num) {
            String s = String.valueOf(num);

            //dp表的定义：长度为i的数字，可以被翻译成dp[i]个字符串
            //如果组成的两位数不能够被翻译，那么dp[i] = dp[i-1]
            //如果组成的两位数可以被翻译，那么dp[i]就是两个选择的方案之和 dp[i] = dp[i-1] + dp[i-2]
            int[] dp = new int[s.length() + 1];

            //初始条件，如果数字长度为1，那么只有一个翻译方案
            //如果长度为2，且满足[10,25]区间，那么就有2种方案，即dp[i-1]+dp[i-2],所以dp[0]也得为1
            dp[0] = dp[1] = 1;

            for (int i = 2; i <= s.length(); i++) {
                String temp = s.substring(i - 2, i);
                if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) {
                    dp[i] = dp[i - 1] + dp[i - 2];
                } else {
                    dp[i] = dp[i - 1];
                }
            }
            return dp[s.length()];
        }
    }
}
