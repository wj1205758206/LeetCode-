
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
        if (x == 0 && n < 0) return -1; //0不能做分母
        if (x == 0) return 0;

        /*使用long类型，将int类型的n扩大表示范围
         * 因为-2147483648取反超出了int类型表示的范围（-2147483648~2147483647）*/
        long absExp = n;
        if (absExp < 0) {
            absExp = -absExp;
        }

        double result = powWithAbsExp(x, absExp);

        if (n < 0) {
            return 1.0 / result;
        }
        return result;
    }

    public double powWithAbsExp(double x, long absExp) {
        if (absExp == 0) return 1;
        if (absExp == 1) return x;

        double result = 1.0;

        while (absExp > 0) {
            if ((absExp & 1) == 1) {
                result *= x;
            }
            x *= x;
            absExp >>= 1;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
