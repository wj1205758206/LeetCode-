
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        if (x == 0) return 0;
        double C = x, x0 = x;
        while (true) {
            // xi = 0.5 * (x0 + C / x0)
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) { //精度
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
