
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lastRemaining(int n, int m) {
        int x = 0; //长度为1时，实际上删除只能是第一个数  0

        //动态规划，递推计算从长度为2开始，到长度为n的环
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        //此时就动态规划，迭代计算出了长度为n该删除的元素时x
        return x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
