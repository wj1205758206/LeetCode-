package dp.hard;


import java.util.*;

/**
 * 自由之路(转转盘)
 */
public class FreedomTrail_514 {
    public static void main(String[] args) {
        Solution solution = new FreedomTrail_514().new Solution();
        System.out.println(solution.findRotateSteps("godding", "gd"));
    }

    class Solution {
        Map<Integer, Character> map = new HashMap<>();
        int[][] memory;

        public int findRotateSteps(String ring, String key) {
            int ringLen = ring.length();
            int keyLen = key.length();
            for (int i = 0; i < ringLen; i++) {
                map.put(i, ring.charAt(i));
            }
            memory = new int[ringLen][keyLen];
            for (int[] row : memory) {
                Arrays.fill(row, 0);
            }

            /*当圆盘指针指向 ring[i] 时，输入字符串 key[j..] 至少需要 dp(ring, i, key, j) 次操作*/
            return dp(ring, 0, key, 0);
        }

        private int dp(String ring, int i, String key, int j) {
            if (j == key.length())
                return 0;

            if (memory[i][j] != 0)
                return memory[i][j];

            List<Integer> index = new LinkedList<>();
            for (int k = 0; k < ring.length(); k++) {
                if (map.get(k) == key.charAt(j)) {
                    index.add(k);
                }
            }

            int result = Integer.MAX_VALUE;
            for (Integer idx : index) {

                /*每次转动我们会选择距离近的方向转动*/
                int minGap = Math.abs(idx - i);
                minGap = Math.min(minGap, ring.length() - minGap);

                int subProblem = dp(ring, idx, key, j + 1);

                /*子问题转动的至少次数，加上本次转动的最少次数 4，再加上按动1次按钮
                 * 因为ring中可能有多个重复字符，所以for循环，选择最小的result*/
                result = Math.min(result, 1 + minGap + subProblem);
            }
            memory[i][j] = result;

            return result;
        }
    }
}
