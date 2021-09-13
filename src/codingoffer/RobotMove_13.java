package codingoffer;

/**
 * 机器人的运动范围(单词搜索的变种)
 */
public class RobotMove_13 {
    public static void main(String[] args) {
        Solution solution = new RobotMove_13().new Solution();
        System.out.println(solution.movingCount(2, 3, 1));
    }

    class Solution {
        int[][] directs = {
                {-1, 0},
                {0, 1},
                {1, 0},
                {0, -1}
        };
        boolean[][] used;
        int count = 0;

        public int movingCount(int m, int n, int k) {
            used = new boolean[m][n];

            backtrack(m, n, 0, 0, k);
            return count;
        }

        private void backtrack(int m, int n, int i, int j, int k) {
            /**
             * 检查将要进入的（i,j）坐标是否合法
             */
            if (isValid(m, n, i, j, k) && !used[i][j]) {
                count++;//合法进入，则数量+1
                used[i][j] = true;//标记为已访问

                /*站在当前（i，j）位置可以向四个方向继续前进
                 * 做出选择，继续下一轮回溯*/
                for (int[] direct : directs) {
                    int newI = i + direct[0];
                    int newJ = j + direct[1];
                    backtrack(m, n, newI, newJ, k);
                }

                /*这个不需要回溯，因为不涉及匹配，只要能进入即可*/
                //used[i][j] = false;
            }
        }

        private boolean isValid(int m, int n, int i, int j, int k) {
            int indexSum = getIndexSum(i) + getIndexSum(j);
            if (i >= 0 && i < m && j >= 0 && j < n && indexSum <= k)
                return true;
            return false;
        }

        private int getIndexSum(int num) {
            int sum = 0;
            while (num != 0) {
                int temp = num % 10;
                sum += temp;
                num /= 10;
            }
            return sum;
        }
    }
}
