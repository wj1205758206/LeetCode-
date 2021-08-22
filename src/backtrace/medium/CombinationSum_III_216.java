package backtrace.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合总和(找出所有相加之和为 n 的 k 个数的组合)
 */
public class CombinationSum_III_216 {
    public static void main(String[] args) {

        Solution solution = new CombinationSum_III_216().new Solution();
        System.out.println(solution.combinationSum3(3, 9));
    }

    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            if (n < k)
                return result;

            List<Integer> track = new ArrayList<>();

            boolean[] used = new boolean[10];

            backtrack(track, 0, k, n, used, 1);

            return result;
        }

        private void backtrack(List<Integer> track, int sum, int k, int n, boolean[] used, int start) {
            if (sum == n && track.size() == k) {
                result.add(new ArrayList<>(track));
                return;
            }

            for (int i = start; i <= 9; i++) {

                if (sum + i > n)
                    continue;

                //解集中不允许有重复的组合，使用used横向控制
                if (used[i])
                    continue;

                track.add(i);
                sum += i;

                //组合中不允许有重复数字，使用 i+1 纵向控制
                backtrack(track, sum, k, n, used, i + 1);

                sum -= i;
                track.remove(track.size() - 1);
            }
        }
    }
}
