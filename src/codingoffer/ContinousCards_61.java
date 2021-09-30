package codingoffer;

import java.util.Arrays;

/**
 * 扑克牌中的顺子
 */
public class ContinousCards_61 {
    public static void main(String[] args) {
        Solution solution = new ContinousCards_61().new Solution();
        System.out.println(solution.isStraight(new int[]{0, 0, 8, 5, 4}));
    }

    class Solution {
        public boolean isStraight(int[] nums) {
            if (nums.length == 0) return false;
            int i = 0, j = 1;
            int zeroCount = 0;
            Arrays.sort(nums);
            while (j < nums.length) {
                //统计0的数量，用来补间隔
                if (nums[i] == 0) {
                    zeroCount++;
                    i++;
                    j++;
                    continue;
                }
                //不能出现对子
                if (nums[i] == nums[j]) return false;
                //如果出现了不连续，尝试用0来补间隔，如果0都用完间隔还大于1，说明0不够用，返回false
                if (Math.abs(nums[i] - nums[j]) - zeroCount > 1) return false;
                i++;
                j++;
            }
            return true;
        }
    }
}
