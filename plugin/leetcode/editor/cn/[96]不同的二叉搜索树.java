
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] mem;

    public int numTrees(int n) {
        mem = new int[n + 1][n + 1];
        // 定义：闭区间 [lo, hi] 的数字能组成 count(lo, hi) 种 BST
        return count(1, n);
    }

    public int count(int low, int high) {
        //[lo, hi]肯定是个空区间，也就对应着空节点 null，
        // 虽然是空节点，但是也是一种情况，所以要返回 1 而不能返回 0。
        if (low > high) return 1;
        if (mem[low][high] != 0) {
            return mem[low][high];
        }

        int res = 0;
        for (int i = low; i <= high; i++) {
            // i 的值作为根节点 root
            int left = count(low, i - 1);
            int right = count(i + 1, high);
            res += left * right;
        }
        mem[low][high] = res;
        return mem[low][high];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
