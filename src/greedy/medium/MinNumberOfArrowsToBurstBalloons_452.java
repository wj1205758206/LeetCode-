package greedy.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 射爆气球最少弓箭数量(贪心算法)
 */
public class MinNumberOfArrowsToBurstBalloons_452 {
    public static void main(String[] args) {
        Solution solution = new MinNumberOfArrowsToBurstBalloons_452().new Solution();
        System.out.println(solution.findMinArrowShots(new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}}));
    }

    class Solution {
        /**
         * 这个题实际上和435题一样的思路，也是使用贪心算法
         * 首先x_end作升序排序
         * 计算出有多少个不相交的point，即x_start>x_end，这时候就需要多使用一支箭
         *
         * @param points
         * @return
         */
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1] > o2[1])
                        return 1;
                    if (o1[1] < o2[1])
                        return -1;
                    return 0;
                }
            });

            int count = 1;
            int x_end = points[0][1];

            for (int i = 0; i < points.length; i++) {
                int x_start = points[i][0];
                if (x_start > x_end) {
                    x_end = points[i][1];
                    count++;
                }
            }
            return count;
        }
    }
}
