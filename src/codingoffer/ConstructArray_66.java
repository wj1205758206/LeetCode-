package codingoffer;

import java.util.Arrays;

/**
 * 构建乘积数组(表格分区)
 */
public class ConstructArray_66 {
    public static void main(String[] args) {
        Solution solution = new ConstructArray_66().new Solution();
        int[] res = solution.constructArr(new int[]{1, 2, 3, 4, 5});
        for (int num : res) {
            System.out.println(num);
        }
    }

    class Solution {
        /**
         * 暴力求解
         *
         * @param a
         * @return
         */
        public int[] constructArr(int[] a) {
            if (a.length == 0) return new int[0];
            int[] b = new int[a.length];
            Arrays.fill(b, 1);
            for (int i = 0; i < b.length; i++) {
                for (int j = 0; j < a.length; j++) {
                    if (i == j) continue;
                    if (a[j] == 0) {
                        b[i] = 0;
                        break;
                    }
                    b[i] *= a[j];
                }
            }
            return b;
        }

        /**
         * 构建乘积数组(表格分区)
         *
         * @param a
         * @return
         */
        public int[] constructArr2(int[] a) {
            int len = a.length;
            if (len == 0) return new int[0];
            int[] b = new int[len];
            b[0] = 1;
            int temp = 1;
            for (int i = 1; i < len; i++) {
                //从上到下，迭代计算下三角每行累乘结果
                b[i] = b[i - 1] * a[i - 1];
            }
            for (int i = len - 2; i >= 0; i--) {
                //从下向上，计算上三角每行累乘结果
                temp *= a[i + 1];
                //每行下三角的结果，再累乘上三角的结果
                b[i] *= temp;
            }
            return b;
        }
    }
}
