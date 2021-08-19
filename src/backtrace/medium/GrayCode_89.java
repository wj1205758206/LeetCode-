package backtrace.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷码
 */
public class GrayCode_89 {
    public static void main(String[] args) {
        Solution solution = new GrayCode_89().new Solution();
        System.out.println(solution.grayCode(3));
    }

    class Solution {
        List<Integer> result = new ArrayList<>();

        public List<Integer> grayCode(int n) {
            result.add(0);
            if (n == 0)
                return result;

            boolean[] used = new boolean[(int) Math.pow(2, n)];
            used[0] = true;

            backtrack(n, result, 0, used);

            return result;
        }

        private boolean backtrack(int n, List<Integer> result, int index, boolean[] used) {
            //找到一个即可返回
            if (result.size() == (int) Math.pow(2, n))
                return true;

            //取出最后一个元素，根据最后一个决定下一个
            int ele = result.get(index);

            //按位异或，挨个翻转每一位
            for (int i = 1; i <= (int) Math.pow(2, n - 1); i *= 2) {

                //作出选择
                int newEle = ele ^ i;
                if (used[newEle])
                    continue;
                used[newEle] = true;
                result.add(newEle);

                //继续下一层回溯
                if (backtrack(n, result, index + 1, used))
                    return true;

                //撤销选择
                result.remove(result.size() - 1);
                used[newEle] = false;
            }
            return false;
        }
    }
}
