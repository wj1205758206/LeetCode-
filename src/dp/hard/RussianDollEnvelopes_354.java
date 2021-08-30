package dp.hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 俄罗斯套娃信封问题
 */
public class RussianDollEnvelopes_354 {
    public static void main(String[] args) {

    }

    class Solution {
        /**
         * 动态规划，但是需要先进行排序处理
         *
         * @param envelopes
         * @return
         */
        public int maxEnvelopes(int[][] envelopes) {
            int n = envelopes.length;

            /*先对宽度 w 进行升序排序，如果遇到 w 相同的情况，则按照高度 h 降序排序。
             *之后把所有的 h 作为一个数组，在这个数组上计算 LIS 的长度就是答案*/
            Arrays.sort(envelopes, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
                }
            });

            int[] height = new int[n];
            for (int i = 0; i < n; i++) {
                height[i] = envelopes[i][1];
            }

            return lengthOfLIS(height);
        }

        public int lengthOfLIS(int[] nums) {
            /*首先一定要明确dp数组的含义，即 dp[i] 的值到底代表着什么？
             * 这里的 dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度。
             *可以假设 dp[0...i-1] 都已经被算出来了，想办法如何通过这些结果算出 dp[i]？
             * */
            int[] dp = new int[nums.length];

            /*定义好dp数组之后，确定基准条件
             * dp[i] 初始值为 1，因为以 nums[i] 结尾的最长递增子序列起码要包含它自己*/
            Arrays.fill(dp, 1);

            /*外层循环遍历nums数组中的每一个元素，计算出以 nums[i] 这个元素结尾的最长递增子序列，并保存在对应的dp[i]中*/
            for (int i = 0; i < nums.length; i++) {
                /*内层循环相当于做出选择，确定状态的转移*/
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        /*设计算法逻辑进行状态转移
                         * 既然是递增子序列，我们只要找到前面那些结尾比当前遍历到的元素 num[i] 小的子序列，
                         * 然后把 num[i] 接到最后，就可以形成一个新的递增子序列，而且这个新的子序列长度加一
                         * 遍历num[i]之前的元素，找出最大的值*/
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }

            /*根据dp数组的这个定义，我们的最终结果（子序列的最大长度）应该是 dp 数组中的最大值。*/
            int result = 0;
            for (int i = 0; i < dp.length; i++) {
                result = Math.max(result, dp[i]);
            }

            return result;
        }
    }
}
