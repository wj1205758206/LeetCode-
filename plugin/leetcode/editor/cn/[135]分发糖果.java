
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int candy(int[] ratings) {
        //数组定义 left[i] 满足左规则 第 i 个孩子所需的糖果数量
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];
        //每个人至少1个
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < ratings.length; i++) {
            //往左看，如果分数高，则多份一颗
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 2; i >= 0; i--) {
            //往右看，如果分数高，则多份一颗
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }
        int count = 0;
        for (int i = 0; i < right.length; i++) {
            //同时满足左右规则的，需要取二者最大值
            count += Math.max(left[i], right[i]);
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
