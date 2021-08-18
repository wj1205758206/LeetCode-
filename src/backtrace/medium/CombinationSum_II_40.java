package backtrace.medium;

import java.util.*;

/**
 * 无序且有重复元素组合之和
 */
public class CombinationSum_II_40 {
    public static void main(String[] args) {
        int[] candidates = {2, 5, 2, 1, 2};

        Solution solution = new CombinationSum_II_40().new Solution();
        System.out.println(solution.combinationSum2(candidates, 5));
    }

    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            if (candidates.length == 0)
                return result;

            List<Integer> track = new ArrayList<>();

            int sum = target;

            //与39题相似，只不过这道题数组无序且有重复元素。我们可以想办法转成39题的样子，先对数组进行升序排序
            Arrays.sort(candidates);

            backtrack(track, sum, candidates, 0);

            return result;
        }

        private void backtrack(List<Integer> track, int sum, int[] candidates, int start) {
            if (sum == 0) {
                //if (isUnique(result, track))
                result.add(new ArrayList<>(track));
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                if (sum - candidates[i] < 0)
                    break;

                //对于重复的元素，我们只需跳过即可，因为下一步选择几个相同的元素进行回溯，计算出的结果一定是选择第一次出现的那个元素的子集
                if (i > start && candidates[i] == candidates[i - 1])
                    continue;

                track.add(candidates[i]);
                sum -= candidates[i];

                backtrack(track, sum, candidates, i + 1);//这里由于39题可以重复选，所以start=i，这题不能重复选，所以start=i+1

                sum += candidates[i];
                track.remove(track.size() - 1);
            }
        }

        /*这种在添加到结果时判断重复的方法，超时*/
        private boolean isUnique(List<List<Integer>> result, List<Integer> track) {
            List<Integer> tempTrack = new ArrayList<>(track);

            Collections.sort(tempTrack);
            for (int i = 0; i < result.size(); i++) {
                Collections.sort(result.get(i));
                if (tempTrack.equals(result.get(i)))
                    return false;
            }
            return true;
        }
    }
}
