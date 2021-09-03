package greedy.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 无重叠区间(贪心算法)
 */
public class NonOverlappingIntervals_435 {
    public static void main(String[] args) {
        Solution solution = new NonOverlappingIntervals_435().new Solution();
        System.out.println(solution.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
    }

    class Solution {
        /**
         * 贪心算法计算出有多少个无重叠的区间，然后用总区间数-无重叠区间数=需要移除的区间数
         *
         * @param intervals
         * @return
         */
        public int eraseOverlapIntervals(int[][] intervals) {
            return intervals.length - intervalSchedule(intervals);
        }

        private int intervalSchedule(int[][] intervals) {
            /*按照最早结束的进行选择
             * 首先给结束时间做升序排序，每次选出最早结束的，也就是end值最小的
             * 然后选出与之不相交的区间，即start>=end的下一个区间
             * 更新新选出的end值，并统计区间个数*/
            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[1] - o2[1];
                }
            });

            int count = 1;
            int x_end = intervals[0][1];
            for (int[] interval : intervals) {
                int start = interval[0];
                if (start >= x_end) {
                    count++;
                    x_end = interval[1];
                }
            }
            return count;
        }
    }
}
