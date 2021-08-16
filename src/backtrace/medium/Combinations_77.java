package backtrace.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 */
public class Combinations_77 {
    public static void main(String[] args) {
        Solution solution = new Combinations_77().new Solution();
        System.out.println(solution.combine(4, 2));
    }

    class Solution {
        List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> combine(int n, int k) {
            if (k > n)
                return result;
            List<Integer> trace = new ArrayList<>();
            backtrace(trace, n, 1, k);

            return result;
        }

        private void backtrace(List<Integer> trace, int n, int start, int k) {
            if (trace.size() == k) {
                result.add(new ArrayList<>(trace));
                return;
            }

            for (int i = start; i <= n; i++) {
                trace.add(i);
                backtrace(trace, n, i + 1, k);
                trace.remove(trace.size() - 1);
            }
        }
    }
}
