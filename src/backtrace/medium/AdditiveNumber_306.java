package backtrace.medium;

/**
 * 累加数
 */
public class AdditiveNumber_306 {
    public static void main(String[] args) {

    }

    class Solution {
        public boolean isAdditiveNumber(String num) {
            if (num.length() < 3)
                return false;

            return backtrack(num, num.length(), 0, 0, 0, 0);
        }

        /**
         * @param num   原始字符串
         * @param len   原始字符串长度
         * @param index 当前下标
         * @param sum   前面两个数之和
         * @param pre   前一个数字
         * @param k     当前是处理的第几个数字
         * @return
         */
        private boolean backtrack(String num, int len, int index, long sum, long pre, int k) {
            if (index == len) {
                return k >= 3;
            }

            for (int i = index; i < len; i++) {
                long value = getCurValue(num, index, i);

                if (value < 0)
                    continue;

                if (k >= 2 && value != sum)
                    continue;

                if (backtrack(num, len, i + 1, pre + value, value, k + 1))
                    return true;
            }
            return false;
        }

        /**
         * @param num   原始字符串
         * @param index 当前处理的下标
         * @param i     选取长度i组成数字
         * @return
         */
        private long getCurValue(String num, int index, int i) {
            if (index < i && num.charAt(index) == '0')
                return -1;

            long res = 0;
            while (index <= i) {
                res = res * 10 + num.charAt(index) - '0';
                index++;
            }
            return res;
        }
    }
}
