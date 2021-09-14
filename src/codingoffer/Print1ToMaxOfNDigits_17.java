package codingoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 打印从1到最大的n位数(使用字符串进行大数处理)
 */
public class Print1ToMaxOfNDigits_17 {
    public static void main(String[] args) {
        Solution solution = new Print1ToMaxOfNDigits_17().new Solution();
        System.out.println(solution.printNumbers2(3));
    }

    class Solution {
        public int[] printNumbers(int n) {
            List<Integer> list = new ArrayList<>();

            int number = 1;
            int i = 0;
            while (i++ < n) {
                number *= 10;
            }

            for (int j = 1; j < number; j++) {
                list.add(j);
            }

            int[] res = new int[list.size()];
            for (int k = 0; k < list.size(); k++) {
                res[k] = list.get(k);
            }
            return res;
        }

        /**
         * 实际上这个题要考的是【大数处理】
         *
         * @param n
         * @return
         */
        public int[] printNumbers2(int n) {
            StringBuilder sb = new StringBuilder();
            char[] track = new char[n];
            char[] select = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

            /*通过回溯实现全排列*/
            backtrack(n, select, track, 0, sb);

            sb.deleteCharAt(sb.length() - 1);
            String[] split = sb.toString().split("\\,");
            int[] result = new int[split.length - 1];
            for (int i = 1; i < split.length; i++) {
                int val = Integer.parseInt(split[i]);
                result[i - 1] = val;
            }

            return result;
        }

        private void backtrack(int n, char[] select, char[] track, int index, StringBuilder sb) {
            if (index == n) {
                sb.append(String.valueOf(track) + ",");
                return;
            }

            for (char c : select) {
                track[index] = c;
                backtrack(n, select, track, index + 1, sb);
            }

        }
    }
}
