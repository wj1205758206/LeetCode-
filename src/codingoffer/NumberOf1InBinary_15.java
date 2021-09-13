package codingoffer;

/**
 * 二进制中1的个数
 */
public class NumberOf1InBinary_15 {
    public static void main(String[] args) {

    }

    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            String s = Integer.toBinaryString(n);

            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1')
                    count++;
            }
            return count;
        }

        public int hammingWeight2(int n) {
            int count = 0;

            while (n != 0) {
                count++;
                //一个整数减去1，再和原来数进行按位与，结果会使得原来的数的二进制最右边的1变为0
                //通过不断的使最右边的1变为0，来计算一共有几个1
                n = n & (n - 1);
            }
            return count;
        }
    }
}
