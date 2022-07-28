
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result < Integer.MIN_VALUE / 10 || result > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = x % 10;
            x /= 10;
            result = result * 10 + digit;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
