package dp.hard;

import java.util.Arrays;

/**
 * 扔鸡蛋(最坏情况下求最少次数)
 */
public class SuperEggDrop_887 {
    public static void main(String[] args) {
        Solution solution = new SuperEggDrop_887().new Solution();
        System.out.println(solution.superEggDrop(6, 10000));
    }

    class Solution {
        int[][] memory;

        public int superEggDrop(int k, int n) {
            memory = new int[k + 1][n + 1];
            for (int[] row : memory) {
                Arrays.fill(row, -1);
            }

            return dp(k, n);
        }

        private int dp(int k, int n) {
            if (k == 1) return n;
            if (n == 0) return 0;

            if (memory[k][n] != -1)
                return memory[k][n];

            int result = Integer.MAX_VALUE;

            int low = 1;
            int high = n;

            while (low <= high) {
                int mid = (low + high) / 2;
                int not_broken = dp(k, n - mid);
                int broken = dp(k - 1, mid - 1);
                if (broken > not_broken) {
                    high = mid - 1;
                    result = Math.min(result, broken + 1);
                } else {
                    low = mid + 1;
                    result = Math.min(result, not_broken + 1);
                }
            }

            /*求最坏情况下，至少扔多少次
             * 内层max求得是最坏情况，因为我们不能拿最好情况说事儿，碰巧走运一次就中的情况我们要排除
             * 外层min求得是至少扔几次，我们可以一层层从低到高的试，也可以二分法的去试，我们应该找到最小值
             * for循环是选择，选择在第i层扔
             * 状态是k个鸡蛋数和测试楼层数，每一次做出选择，剩下的鸡蛋数和剩下的测试楼层数这两个状态在变化，*/
            /*for (int i = 1; i <= n; i++) {
                result = Math.min(result,
                        Math.max(
                                dp(k, n - i),
                                dp(k - 1, i - 1)
                        ) + 1
                );
            }*/

            memory[k][n] = result;

            return result;
        }
    }
}
