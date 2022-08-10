
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        for (int d = n; d / 5 > 0; d /= 5) {
            res += d / 5;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
