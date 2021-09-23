package codingoffer;

/**
 * 1～n 整数中 1 出现的次数
 */
public class NumbersOf1_43 {
    public static void main(String[] args) {
        Solution solution = new NumbersOf1_43().new Solution();
        System.out.println(solution.countDigitOne(12));
    }

    class Solution {
        /**
         * 暴力求解
         *
         * @param n
         * @return
         */
        public int countDigitOne(int n) {
            int count = 0;
            for (int i = 1; i <= n; i++) {
                count += getOf1(i);
            }
            return count;
        }

        private int getOf1(int i) {
            int nums = 0;
            while (i != 0) {
                if (i % 10 == 1)
                    nums++;
                i /= 10;
            }

            return nums;
        }

        /**
         * 数字规律
         *
         * @param n
         * @return
         */
        public int countDigitOne2(int n) {
            int digit = 1, res = 0;
            int cur = n % 10, low = 0, high = n / 10;
            while (high != 0 || cur != 0) {
                if (cur == 0) {
                    res += high * digit;
                } else if (cur == 1) {
                    res += high * digit + low + 1;
                } else if (cur > 1) {
                    res += (high + 1) * digit;
                }

                low += cur * digit;
                cur = high % 10;
                high /= 10;
                digit *= 10;
            }
            return res;
        }
    }
}
