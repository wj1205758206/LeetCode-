package backtrace.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和
 */
public class CombinationSum_39 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};

        Solution solution = new CombinationSum_39().new Solution();
        System.out.println(solution.combinationSum(candidates, 8));
    }

    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            if (candidates.length == 0)
                return result;

            /*int max = 0;
            for (int i = 0; i < candidates.length; i++) {
                if (candidates[max] < candidates[i]) {
                    int temp = candidates[max];
                    candidates[max] = candidates[i];
                    candidates[i] = temp;
                }
            }*/

            List<Integer> track = new ArrayList<>();

            /*回溯
             * 路径：track  sum用来计算当前路径和
             * 选择列表：candidates   start用来控制剩余选择*/
            backtrack(track, 0, candidates, 0, target);

            return result;
        }

        private void backtrack(List<Integer> track, int sum, int[] candidates, int start, int target) {

            //触发结束条件
            if (sum == target) {
                result.add(new ArrayList<>(track));
                return;
            }

            /*从选择列表中作出选择
             * 如果是类似全排列，但能重复选择，但是与排列顺序有关，需要使用used数组来记录是否已经被使用过
             * 如果是类似组合，选择元素的前后顺序无关，[1,2]和[2,1]看作是相同的，需要使用start来控制下一层选择起始点*/
            for (int i = start; i < candidates.length; i++) {

                //剪枝操作
                if (sum + candidates[i] > target)
                    continue;

                //作出选择
                track.add(candidates[i]);
                sum += candidates[i];

                //继续下一层回溯，要注意的是，这里题目要求可以选择重复元素，但组合又与顺序无关，所以下一层start=i
                //这样就可以保证下一层的起始点从上一层的选择开始，满足了可以重复选择元素，又满足了顺序无关性
                backtrack(track, sum, candidates, i, target);

                //撤销选择
                track.remove(track.size() - 1);
                sum -= candidates[i];
            }
        }
    }
}
