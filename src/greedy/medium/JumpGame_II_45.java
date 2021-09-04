package greedy.medium;

import java.util.Arrays;

/**
 * 跳跃游戏(贪心/递归)
 */
public class JumpGame_II_45 {
    public static void main(String[] args) {
        Solution solution = new JumpGame_II_45().new Solution();
        System.out.println(solution.jump(new int[]{2, 3, 0, 1, 4}));
    }

    class Solution {
        /**
         * 方法一：动态规划，自顶向下递归计算
         *
         * @param nums
         * @return
         */
        public int jump(int[] nums) {
            int[] memory = new int[nums.length];
            Arrays.fill(memory, nums.length);

            /*状态：根据选择不同的步数，导致状态索引i发生变化
             * 选择：站在当前索引i上，选择走几步
             * dp函数的定义就是从索引i跳到最后一个元素，最少需要dp(nums,i)步*/
            return dp(nums, 0, memory);
        }

        private int dp(int[] nums, int i, int[] memory) {
            if (i >= nums.length - 1)
                return 0;

            if (memory[i] != nums.length)
                return memory[i];

            int steps = nums[i];
            for (int step = 1; step <= steps; step++) {
                /*做出选择，就会导致状态i的变化，即需要求解i+step子问题*/
                int subProblemSteps = dp(nums, i + step, memory);
                /*子问题+1即可得到当前选择所需要的最少步数，然后和之前的选择比较，选出最小值*/
                memory[i] = Math.min(memory[i], subProblemSteps + 1);
            }
            return memory[i];
        }

        /**
         * 方法二：使用贪心算法，相当于动态规划的优化版。每次选择局部最优解，也就是尽可能每次都跳的最远，这样就不用计算每一个子问题的结果
         *
         * @param nums
         * @return
         */
        public int jump2(int[] nums) {
            int farthest = 0;
            int end = 0;
            int jumps = 0;

            for (int i = 0; i < nums.length - 1; i++) {
                /*i 和 end 标记了可以选择的跳跃步数，
                 *farthest 标记了所有选择 [i..end] 中能够跳到的最远距离
                 * jumps 记录了跳跃次数。*/
                farthest = Math.max(farthest, i + nums[i]);
                if (i == end) {
                    jumps++;
                    end = farthest;
                }
            }
            return jumps;
        }
    }
}
