package codingoffer;

/**
 * 约瑟夫环(动态规划)
 */
public class LastNumberInCircle_62 {
    public static void main(String[] args) {
        Solution solution = new LastNumberInCircle_62().new Solution();
        System.out.println(solution.lastRemaining(5, 3));
    }

    class Solution {
        public int lastRemaining(int n, int m) {
            int x = 0;
            //动态规划，递推计算从长度为2开始，到长度为n的环
            for (int i = 2; i <= n; i++) {
                //约瑟夫环计算公式
                //递推关系式 x→(x+t)%n
                x = (x + m) % i;
            }
            return x;
        }
    }
}
