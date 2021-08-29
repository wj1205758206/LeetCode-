package dp.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 目标和(添加正负号)
 */
public class TargetSum_494 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};

        Solution solution = new TargetSum_494().new Solution();
        System.out.println(solution.findTargetSumWays2(nums, 3));
    }

    class Solution {
        /**
         * 方法一：回溯
         */
        int count = 0;

        public int findTargetSumWays(int[] nums, int target) {

            backtrack(nums, 0, 0, target, new int[]{1, -1});
            return count;
        }

        private void backtrack(int[] nums, int start, int sum, int target, int[] select) {
            if (start == nums.length) {
                if (sum == target)
                    count++;
                return;
            }

            for (int symbol : select) {
                //选择正号还是负号
                sum = sum + (nums[start] * symbol);
                backtrack(nums, start + 1, sum, target, select);
                sum = sum - (nums[start] * symbol);
            }
            /*sum += nums[start];
            backtrack(nums, start + 1, sum, target);
            sum -= nums[start];

            sum -= nums[start];
            backtrack(nums, start + 1, sum, target);
            sum += nums[start];*/
        }

        /**
         * 方法二：使用备忘录的递归
         */
        Map<String, Integer> memory = new HashMap<>();

        public int findTargetSumWays2(int[] nums, int target) {
            return DFS(nums, 0, 0, target);
        }

        private int DFS(int[] nums, int index, int sum, int target) {
            //基准条件，如果满足条件则返回1，表示找到一种方案，不断累加
            if (index == nums.length) {
                if (sum == target)
                    return 1;
                return 0;
            }

            /*要想去除重叠子问题，就要先确定重复出现的【状态】
             * 这里参数index 和参数sum就是状态，一起构成了需要求解的子问题
             * 因为正好和符号，导致状态(index,sum)在改变*/
            String key = index + "," + sum;

            /*先从备忘录里面查
             * 如果之前计算过：到index索引位置结果为sum的情况
             * 就直接返回即可，然后继续计算index+1时，sum的变化
             * 这样就直接利用(index+sum)的计算结果，来计算(index+1)的sum结果*/
            if (memory.containsKey(key))
                return memory.get(key);

            /*根据当前状态(index,sum)，我们需要计算下一个状态(index+1,sum-X)和(index+1,sum+X)
             * 由于可能取正号或者负号，所以两种情况相加
             * 这里DFS函数定义是，在已经计算出0-index，和为sum的情况下，如何选择剩余的元素，保证nums和为target的方案有几种*/
            int res = DFS(nums, index + 1, sum - nums[index], target) +
                    DFS(nums, index + 1, sum + nums[index], target);
            memory.put(key, res);

            return res;

        }
    }
}
