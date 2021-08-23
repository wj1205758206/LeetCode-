package backtrace.medium;

import java.util.Arrays;
import java.util.Collections;

/**
 * 火柴拼正方形
 */
public class MatchsticksToSquare_473 {
    public static void main(String[] args) {
        int[] matchsticks = {3, 3, 3, 3, 4};

        Solution solution = new MatchsticksToSquare_473().new Solution();
        System.out.println(solution.makesquare(matchsticks));
    }

    class Solution {
        public boolean makesquare(int[] matchsticks) {
            int sum = 0;
            for (int i = 0; i < matchsticks.length; i++) {
                sum += matchsticks[i];
            }

            if (matchsticks.length == 0 || sum % 4 != 0)
                return false;


            Arrays.sort(matchsticks);
            Collections.reverse(Collections.singletonList(matchsticks));

            return backtrack(matchsticks, 0, new int[4], sum / 4);
        }

        private boolean backtrack(int[] matchsticks, int start, int[] size, int len) {

            //start控制路径，当start等于数组的长度，说明数组的所有元素都被使用了，此时需要判断正方形的四条边是否都相等
            if (start == matchsticks.length) {
                if (size[0] == size[1] && size[1] == size[2] && size[2] == size[3])
                    return true;
                return false;
            }

            //这里的选择列表并不是选取数组中的哪个元素！而是从数组中获取元素放在正方形的哪条边上！
            for (int i = 0; i < size.length; i++) {

                //剪枝：如果数组中当前操作的元素放在选择的第i条边上，使得边的长度超过了平均值，则不合法
                //或者说，当前选择的第i条边和i-1条边是一样长的，那么既然i-1没有放成功，那么第i条肯定也不成功
                if (size[i] + matchsticks[start] > len || (i > 0 && size[i - 1] == size[i]))
                    continue;

                size[i] += matchsticks[start];

                if (backtrack(matchsticks, start + 1, size, len))
                    return true;

                size[i] -= matchsticks[start];
            }
            return false;
        }
    }
}
