package codingoffer;

/**
 * 数值的整数次方(快速幂)
 */
public class Power_16 {
    public static void main(String[] args) {
        Solution solution = new Power_16().new Solution();
        System.out.println(solution.myPow(2.00000, -2147483648));
    }

    class Solution {
        /**
         * 快速幂
         *
         * @param x
         * @param n
         * @return
         */
        public double myPow(double x, int n) {
            if (x == 0 && n < 0)
                return -1;
            if (x == 0)
                return 0;

            /*使用long类型，将int类型的n扩大表示范围
             * 因为-2147483648取反超出了int类型表示的范围（-2147483648~2147483647）*/
            long absExp = n;
            if (absExp < 0)
                absExp = -absExp;

            double result = powerWithAbsExp(x, absExp);

            if (n < 0)
                return 1.0 / result;
            return result;
        }

        private double powerWithAbsExp(double x, long absExp) {
            if (absExp == 0) return 1;
            if (absExp == 1) return x;

            double res = 1.0;

            /*快速幂*/
            while (absExp > 0) {
                //判断二进制最后一位是否为1，只有在1的位置上，才有相应的权重。是的话就累乘权重
                if ((absExp & 1) == 1)
                    res *= x;
                x *= x;//相当于每次循环底数就会翻倍，累乘的过程，对应的幂次数要减半，累乘的结果相当于权重
                absExp >>= 1;
            }

            return res;
        }
    }
}
