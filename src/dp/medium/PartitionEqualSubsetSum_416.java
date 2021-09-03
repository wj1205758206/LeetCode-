package dp.medium;

/**
 * 分割等和子集
 */
public class PartitionEqualSubsetSum_416 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5};

        Solution solution = new PartitionEqualSubsetSum_416().new Solution();
        System.out.println(solution.canPartition(nums));
    }

    class Solution {
        /**
         * 分割成两个和相等的子集，实际上也是 0-1 背包问题
         *
         * @param nums
         * @return
         */
        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }

            /*如果数组元素和为奇数，那么就无法平均分割成相等的和，直接返回false*/
            if (sum % 2 != 0) return false;

            int target = sum / 2;

            /*首先明确dp数组的定义
             * dp[N][target]表示的是前N的元素是否能分割成和为target的两个子集*/
            boolean[][] dp = new boolean[nums.length + 1][target + 1];

            /*基准条件
             * 当target为0是，也就是是否能够装满容量为0的背包，这肯定能装满
             * 当N为0时，也就是说没有元素可以选择来填充背包，所以无法装满*/
            for (int i = 0; i < dp.length; i++) {
                dp[i][0] = true;
            }
            for (int j = 0; j < dp[0].length; j++) {
                dp[0][j] = false;
            }

            /*这里状态有两个：
             *一个是剩余可能使用的元素（对应第一个for循环），
             * 另一个是当前元素和（对应第二个for循环）
             * 而可以做出的选择为当前的元素你是选择放入背包还是选择不放入背包*/
            for (int i = 1; i <= nums.length; i++) {
                for (int j = 1; j <= target; j++) {
                    /*如果数当前背包容量不足放下当前的元素，则直接继承上一个元素对应的状态*/
                    if (j - nums[i - 1] < 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        /*如果背包当前容量充足，可以放入当前元素
                         * 那么此时你需要做出选择，是放还是不放
                         * 不放，则继承上一个元素对应的状态
                         * 放，则基于上一个元素对应的背包容量减去当前元素需要占用的容量*/
                        dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                    }
                }
            }
            return dp[nums.length][target];
        }
    }
}
