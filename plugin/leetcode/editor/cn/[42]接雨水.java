
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int lMax = 0, rMax = 0;
        int res = 0;
        while (left < right) {
            //l_max 是 height[0..left] 中最高柱子的高度，r_max 是 height[right..end] 的最高柱子的高度。
            lMax = Math.max(lMax, height[left]);
            rMax = Math.max(rMax, height[right]);
            if (lMax < rMax) {
                res += lMax - height[left]; //只看左边
                left++;
            } else {
                res += rMax - height[right]; //只看右边
                right--;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
