package codingoffer;

/**
 * 位运算实现加法
 */
public class AddTwoNumbers_65 {
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers_65().new Solution();
        System.out.println(solution.add(4, 5));
    }

    class Solution {
        public int add(int a, int b) {
            //直到进位为0，返回a即可
            if (b == 0) return a;

            //a + b 等价于 非进位和 + 进位
            //循环求 n(非进位和) 和 c(进位) ，直至进位 c=0 ；此时 s=n ，返回 n 即可。
            return add(a ^ b, (a & b) << 1);
        }
    }
}
