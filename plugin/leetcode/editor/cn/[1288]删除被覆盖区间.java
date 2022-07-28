
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a,b) -> {
           if (a[0] == b[0]){
               return b[1] - a[1];
           }
           return a[0] - b[0];
        });

        int left = intervals[0][0];
        int right = intervals[0][1];

        int count = 0;
        for (int i = 1; i < intervals.length; i++){
            int[] intv = intervals[i];
            if (left <= intv[0] && intv[1] <= right){
                count++;
            }
            if (intv[0] <= right && intv[1] >= right){
                right = intv[1];
            }
            if (right < intv[0]){
                left = intv[0];
                right = intv[1];
            }
        }
        return intervals.length - count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
