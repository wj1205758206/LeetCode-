package backtrace.medium;

/**
 * 计算各个位数不同的数字个数
 */
public class CountNumbersWithUniqueDigits_357 {
    public static void main(String[] args) {
        Solution solution = new CountNumbersWithUniqueDigits_357().new Solution();
        System.out.println(solution.countNumbersWithUniqueDigits(8));
    }

    class Solution {


        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0)
                return 1;

            boolean[] used = new boolean[10];


            return backtrack(n, 0, used);


        }

        private int backtrack(int n, int index, boolean[] used) {
            int count = 0;

            if (index != n) {
                for (int i = 0; i < 10; i++) {
                    if (n > 1 && index == 1 && i == 0)
                        continue;
                    if (used[i])
                        continue;

                    used[i] = true;
                    count = count + (backtrack(n, index + 1, used) + 1);
                    used[i] = false;
                }
            }
            return count;
        }
    }
}
