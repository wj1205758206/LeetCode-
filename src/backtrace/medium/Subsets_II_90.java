package backtrace.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 无序重复数组求子集
 */
public class Subsets_II_90 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};

        Solution solution = new Subsets_II_90().new Solution();
        System.out.println(solution.subsetsWithDup(nums));
    }

    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            if (nums.length == 0)
                return result;

            //去重必须先排序
            Arrays.sort(nums);

            List<Integer> track = new ArrayList<>();

            backtrack(track, nums, 0);

            return result;
        }

        private void backtrack(List<Integer> track, int[] nums, int start) {
            result.add(new ArrayList<>(track));

            for (int i = start; i < nums.length; i++) {

                //用来控制横向不能重复选取
                if (i > start && nums[i] == nums[i - 1])
                    continue;

                track.add(nums[i]);

                //不是全排列，不能每次从0开始，
                //集合与顺序无关，i+i 用来控制纵向不能重复选取，选过的不能再选，集合中本身就有重复的元素可以选取
                backtrack(track, nums, i + 1);

                track.remove(track.size() - 1);
            }
        }
    }

}
